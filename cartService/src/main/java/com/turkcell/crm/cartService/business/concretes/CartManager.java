package com.turkcell.crm.cartService.business.concretes;

import com.turkcell.crm.cartService.business.abstracts.CartService;
import com.turkcell.crm.cartService.business.dtos.requests.CreateCartRequest;
import com.turkcell.crm.cartService.business.dtos.requests.UpdateCartRequest;
import com.turkcell.crm.cartService.business.dtos.responses.CreatedCartResponse;
import com.turkcell.crm.cartService.business.dtos.responses.GetAllCartsResponse;
import com.turkcell.crm.cartService.business.dtos.responses.GetCartResponse;
import com.turkcell.crm.cartService.business.dtos.responses.UpdatedCartResponse;
import com.turkcell.crm.cartService.clients.ProductServiceClient;
import com.turkcell.crm.cartService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.cartService.dataAccess.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CartManager implements CartService {
    private final CartRepository cartRepository;
    private final ModelMapperService modelMapperService;
    private final ProductServiceClient productServiceClient;

    @Override
    public void addProductToCart(int productId, int cartId) {
        boolean feign = this.productServiceClient.isExist(productId);
        if (feign) {
            // add product to cart
        }
    }

    @Override
    public void removeProductFromCart(int productId, int cartId) {

    }

    @Override
    public void clearCart(int cartId) {

    }

    @Override
    public CreatedCartResponse createCart(CreateCartRequest createCartRequest) {
        return null;

    }

    @Override
    public void deleteCart(int cartId) {

    }

    @Override
    public UpdatedCartResponse updateCart(UpdateCartRequest updateCartRequest) {
        return null;
    }

    @Override
    public GetCartResponse getCart(int cartId) {
        return null;
    }

    @Override
    public List<GetAllCartsResponse> getAllCarts() {
        return null;
    }
}
