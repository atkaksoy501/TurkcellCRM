package com.turkcell.crm.cartService.business.concretes;

import com.turkcell.crm.cartService.business.abstracts.CartService;
import com.turkcell.crm.cartService.business.dtos.requests.AddProductToCartRequest;
import com.turkcell.crm.cartService.business.dtos.requests.CreateCartRequest;
import com.turkcell.crm.cartService.business.dtos.requests.UpdateCartRequest;
import com.turkcell.crm.cartService.business.dtos.responses.CreatedCartResponse;
import com.turkcell.crm.cartService.business.dtos.responses.GetAllCartsResponse;
import com.turkcell.crm.cartService.business.dtos.responses.GetCartResponse;
import com.turkcell.crm.cartService.business.dtos.responses.UpdatedCartResponse;
import com.turkcell.crm.cartService.clients.ProductServiceClient;
import com.turkcell.crm.cartService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.cartService.entities.concretes.Cart;
import com.turkcell.crm.cartService.entities.concretes.CartItem;
import com.turkcell.crm.cartService.repositories.RedisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class CartManager implements CartService {
    private final ModelMapperService modelMapperService;
    private final ProductServiceClient productServiceClient;
    private final RedisRepository redisRepository;

    @Override
    public void addProductToCart(AddProductToCartRequest addProductToCartRequest) {
        Object product = productServiceClient.getProductById(addProductToCartRequest.getProductId()); //todo: denenecek security sorunları var.
        Cart cart = redisRepository.getCartByAccountId(addProductToCartRequest.getAccountId());
        if (cart == null) {
            cart = new Cart();
        }
        cart.setAccountId(addProductToCartRequest.getAccountId());
        CartItem cartItem = new CartItem();
        cartItem.setProductId(addProductToCartRequest.getProductId());
        cartItem.setQuantity(addProductToCartRequest.getQuantity());
        cartItem.setPrice(addProductToCartRequest.getPrice());
        cartItem.setActive(true);
        cartItem.setCreatedDate(LocalDateTime.now());
        cart.setTotalPrice(cart.getTotalPrice() + (cartItem.getPrice() * cartItem.getQuantity()));
        cart.getItems().add(cartItem);
        redisRepository.addItem(cart);
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
