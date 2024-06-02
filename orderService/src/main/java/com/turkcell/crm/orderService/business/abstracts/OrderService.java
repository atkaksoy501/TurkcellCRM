package com.turkcell.crm.orderService.business.abstracts;

import com.turkcell.crm.orderService.business.dtos.requests.CreateOrderRequest;
import com.turkcell.crm.orderService.business.dtos.requests.UpdateOrderRequest;
import com.turkcell.crm.orderService.business.dtos.responses.CreatedOrderResponse;
import com.turkcell.crm.orderService.business.dtos.responses.GetAllOrdersResponse;
import com.turkcell.crm.orderService.business.dtos.responses.GetOrderByIdResponse;
import com.turkcell.crm.orderService.business.dtos.responses.UpdatedOrderResponse;
import org.hibernate.sql.Update;

import java.util.List;

public interface OrderService {
    CreatedOrderResponse save(CreateOrderRequest createOrderRequest);
    UpdatedOrderResponse update(UpdateOrderRequest updateOrderRequest);
    void delete(int id);
    GetOrderByIdResponse getById(int id);
    List<GetAllOrdersResponse> getAll();

    boolean isOrderProductExist(int accountId);
}
