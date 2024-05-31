package com.turkcell.crm.cartService.api.controllers;

import com.turkcell.crm.cartService.business.abstracts.CartService;
import com.turkcell.crm.cartService.business.dtos.requests.AddProductToCartRequest;
import com.turkcell.crm.cartService.business.dtos.requests.CreateCartRequest;
import com.turkcell.crm.cartService.business.dtos.requests.UpdateCartRequest;
import com.turkcell.crm.cartService.business.dtos.responses.CreatedCartResponse;
import com.turkcell.crm.cartService.business.dtos.responses.GetAllCartsResponse;
import com.turkcell.crm.cartService.business.dtos.responses.GetCartResponse;
import com.turkcell.crm.cartService.business.dtos.responses.UpdatedCartResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartsController {
    private final CartService cartService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCartResponse add(CreateCartRequest createCartRequest) {
        return cartService.createCart(createCartRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCartResponse update(UpdateCartRequest updateCartRequest) {
        return cartService.updateCart(updateCartRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        cartService.deleteCart(id);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCartResponse get(@PathVariable int id) {
        return cartService.getCart(id);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCartsResponse> getAll() {
        return cartService.getAllCarts();
    }

    @PostMapping("/addproduct")
    @ResponseStatus(HttpStatus.OK)
    public void addProductToCart(AddProductToCartRequest addProductToCartRequest) {
        cartService.addProductToCart(addProductToCartRequest);
    }

    @DeleteMapping("/removeproduct/{productId}/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeProductFromCart(int productId, int cartId) {
        cartService.removeProductFromCart(productId, cartId);
    }

    @DeleteMapping("/clear")
    @ResponseStatus(HttpStatus.OK)
    public void clearCart(int cartId) {
        cartService.clearCart(cartId);
    }


}
