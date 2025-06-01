package com.softwares.service.impl;

import com.softwares.exceptions.ProductException;
import com.softwares.models.Cart;
import com.softwares.models.CartItem;
import com.softwares.models.Product;
import com.softwares.models.User;
import com.softwares.repository.CartItemRepository;
import com.softwares.repository.CartRepository;
import com.softwares.service.CartService;
import com.softwares.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;


    public Cart findUserCart(User user) {
        Cart cart =	cartRepository.findByUserId(user.getId());

        int totalPrice=0;
        int totalDiscountedPrice=0;
        int totalItem=0;
        for(CartItem cartsItem : cart.getCarItems()) {
            totalPrice+=cartsItem.getMrpPrice();
            totalDiscountedPrice+=cartsItem.getSellingPrice();
            totalItem+=cartsItem.getQuantity();
        }

        cart.setTotalMrpPrice(totalPrice);
        cart.setTotalItem(cart.getCarItems().size());
        cart.setTotalSellingPrice(totalDiscountedPrice-cart.getCouponPrice());
        cart.setDiscount(calculateDiscountPercentage(totalPrice,totalDiscountedPrice));
        cart.setTotalItem(totalItem);

        return cartRepository.save(cart);

    }

    public static int calculateDiscountPercentage(double mrpPrice, double sellingPrice) {
        if (mrpPrice <= 0) {
            return 0;
        }
        double discount = mrpPrice - sellingPrice;
        double discountPercentage = (discount / mrpPrice) * 100;
        return (int) discountPercentage;
    }

    @Override
    public CartItem addCartItem(User user,
                                Product product,
                                String size,
                                int quantity
    ) throws ProductException {
        Cart cart=findUserCart(user);

        CartItem isPresent=cartItemRepository.findByCartAndProductAndSize(
                cart, product, size);

        if(isPresent == null) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);

            cartItem.setQuantity(quantity);
            cartItem.setUserId(user.getId());

            int totalPrice=quantity*product.getSellingPrice();
            cartItem.setSellingPrice(totalPrice);
            cartItem.setMrpPrice(quantity*product.getMrpPrice());
            cartItem.setSize(size);

            cart.getCarItems().add(cartItem);
            cartItem.setCart(cart);

            return cartItemRepository.save(cartItem);
        }

        return isPresent;
    }
}
