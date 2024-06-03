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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        cartItem.setPrice(1);
        cart.setTotalPrice(cart.getTotalPrice() + cartItem.getPrice());
        cart.getItems().add(cartItem);
        redisRepository.addItem(cart);
    }

    @Override
    public void removeProductFromCart(int productId, int cartId) {

        Cart cart = redisRepository.getCartByAccountId(String.valueOf(cartId));
        if (cart != null) {
            CartItem itemToRemove = null;
            for (CartItem item : cart.getItems()) {
                if (item.getProductId() == productId) {
                    itemToRemove = item;
                    break;
                }
            }
            if (itemToRemove != null) {
                cart.getItems().remove(itemToRemove);
                cart.setTotalPrice(cart.getTotalPrice() - itemToRemove.getPrice());
                redisRepository.addItem(cart);
            }
        }
    }

    @Override
    public void clearCart(int cartId) {

        Cart cart = redisRepository.getCartByAccountId(String.valueOf(cartId));
        if (cart != null) {
            cart.getItems().clear();
            cart.setTotalPrice(0);
            redisRepository.addItem(cart);
        }

    }

    @Override
    public CreatedCartResponse createCart(CreateCartRequest createCartRequest) {
        Cart cart = new Cart();
        cart.setAccountId(createCartRequest.getAccountId());
        redisRepository.addItem(cart);
        return modelMapperService.forResponse().map(cart, CreatedCartResponse.class);

    }

    @Override
    public void deleteCart(int cartId) {redisRepository.deleteItem(String.valueOf(cartId));}

    @Override
    public UpdatedCartResponse updateCart(UpdateCartRequest updateCartRequest) {

        Cart cart = redisRepository.getCartByAccountId(updateCartRequest.getAccountId());
        if (cart != null) {
            cart.setTotalPrice(updateCartRequest.getTotalPrice());
            cart.setItems(updateCartRequest.getItems());
            redisRepository.addItem(cart);
            return modelMapperService.forResponse().map(cart, UpdatedCartResponse.class);
        }
        return null;
    }

    @Override
    public GetCartResponse getCart(int cartId) {
        Cart cart = redisRepository.getCartByAccountId(String.valueOf(cartId));
        if (cart != null) {
            return modelMapperService.forResponse().map(cart, GetCartResponse.class);
        }
        return null;
    }

    @Override
    public List<GetAllCartsResponse> getAllCarts() {

        Map<String, Cart> carts = redisRepository.getAllItems();
        List<GetAllCartsResponse> response = carts.values().stream()
                .map(cart -> modelMapperService.forResponse().map(cart, GetAllCartsResponse.class))
                .collect(Collectors.toList());
        return response;
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
