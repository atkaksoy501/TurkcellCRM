package com.turkcell.crm.orderService.api.controllers;

import com.turkcell.crm.orderService.business.abstracts.OrderService;
import com.turkcell.crm.orderService.business.dtos.requests.CreateOrderRequest;
import com.turkcell.crm.orderService.business.dtos.requests.UpdateOrderRequest;
import com.turkcell.crm.orderService.business.dtos.responses.CreatedOrderResponse;
import com.turkcell.crm.orderService.business.dtos.responses.GetAllOrdersResponse;
import com.turkcell.crm.orderService.business.dtos.responses.GetOrderByIdResponse;
import com.turkcell.crm.orderService.business.dtos.responses.UpdatedOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final OrderService orderService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedOrderResponse add(CreateOrderRequest createOrderRequest) {
        return orderService.save(createOrderRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedOrderResponse update(UpdateOrderRequest updateOrderRequest) {
        return orderService.update(updateOrderRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetOrderByIdResponse get(@PathVariable int id) {
        return orderService.getById(id);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllOrdersResponse> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/isOrderProductExist/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isOrderProductExistByAccountId(@PathVariable int accountId) {

        return orderService.isOrderProductExist(accountId);
    }
}
