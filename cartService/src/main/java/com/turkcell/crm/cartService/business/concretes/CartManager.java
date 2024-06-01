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
import java.util.Map;

@AllArgsConstructor
@Service
public class CartManager implements CartService {
    private final ModelMapperService modelMapperService;
    private final ProductServiceClient productServiceClient;
    private final RedisRepository redisRepository;

    @Override
    public void addProductToCart(AddProductToCartRequest addProductToCartRequest) {
       boolean isProductExist = productServiceClient.isProductExist(addProductToCartRequest.getProductId());
        Object product = productServiceClient.getById(addProductToCartRequest.getProductId());

        Cart cart = redisRepository.getCartByAccountId(addProductToCartRequest.getAccountId());
        if (cart == null) {
            cart = new Cart();
        }
        cart.setAccountId(addProductToCartRequest.getAccountId());
        CartItem cartItem = new CartItem();
        cartItem.setProductId(addProductToCartRequest.getProductId());
        cartItem.setPrice();
        cart.setTotalPrice(cart.getTotalPrice() + cartItem.getPrice());
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

    @Override
    public GetCartResponse getCartByAccountId(String accountId) {
        Cart cart = redisRepository.getCartByAccountId(accountId);
        GetCartResponse getCartResponse = modelMapperService.forResponse().map(cart, GetCartResponse.class);
        return getCartResponse;
    }

    @Override
    public Map<String,Cart> getAllItems(){
        return this.redisRepository.getAllItems();
    }
}
