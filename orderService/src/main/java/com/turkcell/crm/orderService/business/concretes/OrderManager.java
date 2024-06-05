package com.turkcell.crm.orderService.business.concretes;

import com.turkcell.crm.common.events.order.CreateOrderProductsEvent;
import com.turkcell.crm.orderService.business.abstracts.OrderService;
import com.turkcell.crm.orderService.business.dtos.requests.CreateOrderRequest;
import com.turkcell.crm.orderService.business.dtos.requests.UpdateOrderRequest;
import com.turkcell.crm.orderService.business.dtos.responses.*;
import com.turkcell.crm.orderService.business.rules.OrderBusinessRules;
import com.turkcell.crm.orderService.clients.AddressServiceClient;
import com.turkcell.crm.orderService.clients.CartServiceClient;
import com.turkcell.crm.orderService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.orderService.dataAccess.OrderRepository;
import com.turkcell.crm.orderService.entities.concretes.Order;
import com.turkcell.crm.orderService.kafka.producers.OrderProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapperService modelMapperService;
    private final OrderBusinessRules orderBusinessRules;
    private final OrderProducer orderProducer;
    private final AddressServiceClient addressServiceClient;
    private final CartServiceClient cartServiceClient;

    @Override
    @Transactional
    public CreatedOrderResponse save(CreateOrderRequest createOrderRequest) {

        Order order = modelMapperService.forRequest().map(createOrderRequest, Order.class);
        order.setCreatedDate(LocalDateTime.now());

        CreateOrderProductsEvent createOrderProductsEvent = new CreateOrderProductsEvent();
        createOrderProductsEvent.setProductIds(createOrderRequest.getProductIds());
        createOrderProductsEvent.setAccountId(createOrderRequest.getAccountId());
        orderProducer.sendMessage(createOrderProductsEvent);

        double totalPrice = cartServiceClient.getTotalPriceByAccountId(createOrderRequest.getAccountId());
        order.setTotalAmount(totalPrice);

        orderRepository.save(order);

        GetAddressResponseById address = addressServiceClient.getById(createOrderRequest.getAddressId());
        CreatedOrderResponse createdOrderResponse = modelMapperService.forResponse().map(order, CreatedOrderResponse.class);
        createdOrderResponse.setAddress(address);

        return createdOrderResponse;
    }

    @Override
    public UpdatedOrderResponse update(UpdateOrderRequest updateOrderRequest) {

        orderBusinessRules.orderMustExist(updateOrderRequest.getId());

        Order order = orderRepository.findById(updateOrderRequest.getId()).orElse(null);
        modelMapperService.forUpdate().map(updateOrderRequest, order);
        order.setUpdatedDate(LocalDateTime.now());

        orderRepository.save(order);

        GetAddressResponseById address = addressServiceClient.getById(updateOrderRequest.getAddressId());
        UpdatedOrderResponse updatedOrderResponse = modelMapperService.forResponse().map(order, UpdatedOrderResponse.class);
        updatedOrderResponse.setAddress(address);
        return updatedOrderResponse;
    }

    @Override
    public void delete(int id) {

        orderBusinessRules.orderMustExist(id);

        Order order = orderRepository.findById(id).orElse(null);
        order.setDeletedDate(LocalDateTime.now());
        order.setActive(false);

        orderRepository.save(order);
    }

    @Override
    public GetOrderByIdResponse getById(int id) {

        orderBusinessRules.orderMustExist(id);

        Order order = orderRepository.findById(id).orElse(null);

        GetAddressResponseById address = addressServiceClient.getById(order.getAddressId());

        GetOrderByIdResponse getOrderByIdResponse = modelMapperService.forResponse().map(order, GetOrderByIdResponse.class);
        getOrderByIdResponse.setAddress(address);

        return getOrderByIdResponse;
    }

    @Override
    public List<GetAllOrdersResponse> getAll() {

        List<Order> orders = orderRepository.findAll().stream().filter(Order::isActive).toList();

        return orders.stream().map(order -> modelMapperService.forResponse().map(order, GetAllOrdersResponse.class)).toList();
    }

    @Override
    public boolean isOrderProductExist(int accountId) {
        return orderRepository.existsByAccountIdAndProductIdsIsNotEmpty(accountId);
    }
}
