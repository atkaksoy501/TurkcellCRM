package com.turkcell.crm.orderService.business.concretes;

import com.turkcell.crm.orderService.business.abstracts.OrderService;
import com.turkcell.crm.orderService.business.dtos.requests.CreateOrderRequest;
import com.turkcell.crm.orderService.business.dtos.requests.UpdateOrderRequest;
import com.turkcell.crm.orderService.business.dtos.responses.CreatedOrderResponse;
import com.turkcell.crm.orderService.business.dtos.responses.GetAllOrdersResponse;
import com.turkcell.crm.orderService.business.dtos.responses.GetOrderByIdResponse;
import com.turkcell.crm.orderService.business.dtos.responses.UpdatedOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {

    @Override
    public CreatedOrderResponse save(CreateOrderRequest createOrderRequest) {
        return null;
    }

    @Override
    public UpdatedOrderResponse update(UpdateOrderRequest updateOrderRequest) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public GetOrderByIdResponse getById(int id) {
        return null;
    }

    @Override
    public List<GetAllOrdersResponse> getAll() {
        return null;
    }
}
