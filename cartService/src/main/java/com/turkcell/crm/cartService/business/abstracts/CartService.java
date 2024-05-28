package com.turkcell.crm.cartService.business.abstracts;

import com.turkcell.crm.cartService.business.dtos.requests.AddProductToCartRequest;
import com.turkcell.crm.cartService.business.dtos.requests.CreateCartRequest;
import com.turkcell.crm.cartService.business.dtos.requests.UpdateCartRequest;
import com.turkcell.crm.cartService.business.dtos.responses.CreatedCartResponse;
import com.turkcell.crm.cartService.business.dtos.responses.GetAllCartsResponse;
import com.turkcell.crm.cartService.business.dtos.responses.GetCartResponse;
import com.turkcell.crm.cartService.business.dtos.responses.UpdatedCartResponse;

import java.util.List;

public interface CartService {
    void addProductToCart(AddProductToCartRequest addProductToCartRequest);
    void removeProductFromCart(int productId, int cartId);
    void clearCart(int cartId);
    CreatedCartResponse createCart(CreateCartRequest createCartRequest);
    void deleteCart(int cartId);
    UpdatedCartResponse updateCart(UpdateCartRequest updateCartRequest);
    GetCartResponse getCart(int cartId);
    List<GetAllCartsResponse> getAllCarts();
}
