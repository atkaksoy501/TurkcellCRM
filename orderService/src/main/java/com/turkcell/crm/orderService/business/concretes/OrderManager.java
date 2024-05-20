package com.turkcell.crm.orderService.business.concretes;

import com.turkcell.crm.orderService.business.abstracts.OrderService;
import com.turkcell.crm.orderService.business.dtos.requests.CreateOrderRequest;
import com.turkcell.crm.orderService.business.dtos.requests.UpdateOrderRequest;
import com.turkcell.crm.orderService.business.dtos.responses.CreatedOrderResponse;
import com.turkcell.crm.orderService.business.dtos.responses.GetAllOrdersResponse;
import com.turkcell.crm.orderService.business.dtos.responses.GetOrderByIdResponse;
import com.turkcell.crm.orderService.business.dtos.responses.UpdatedOrderResponse;
import com.turkcell.crm.orderService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.orderService.dataAccess.OrderRepository;
import com.turkcell.crm.orderService.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public CreatedOrderResponse save(CreateOrderRequest createOrderRequest) {
        Order order = modelMapperService.forRequest().map(createOrderRequest, Order.class);
        order.setCreatedDate(LocalDateTime.now());
        orderRepository.save(order);
        return modelMapperService.forResponse().map(order, CreatedOrderResponse.class);
    }

    @Override
    public UpdatedOrderResponse update(UpdateOrderRequest updateOrderRequest) {
        Order order = orderRepository.findById(updateOrderRequest.getId()).orElse(null);
        modelMapperService.forUpdate().map(updateOrderRequest, order);
        order.setUpdatedDate(LocalDateTime.now());
        orderRepository.save(order);
        return modelMapperService.forResponse().map(order, UpdatedOrderResponse.class);
    }

    @Override
    public void delete(int id) {
        Order order = orderRepository.findById(id).orElse(null);
        order.setDeletedDate(LocalDateTime.now());
        order.setActive(false);
        orderRepository.save(order);
    }

    @Override
    public GetOrderByIdResponse getById(int id) {
        Order order = orderRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(order, GetOrderByIdResponse.class);
    }

    @Override
    public List<GetAllOrdersResponse> getAll() {
        List<Order> orders = orderRepository.findAll().stream().filter(Order::isActive).toList();
        return orders.stream().map(order -> modelMapperService.forResponse().map(order, GetAllOrdersResponse.class)).toList();
    }
}
