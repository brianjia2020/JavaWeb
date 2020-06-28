package com.atguigu.test;

import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",2,new BigDecimal(20),new BigDecimal(40)));
        cart.addItem(new CartItem(1,"java",2,new BigDecimal(20),new BigDecimal(40)));
        cart.addItem(new CartItem(2,"java2",2,new BigDecimal(20),new BigDecimal(40)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",2,new BigDecimal(20),new BigDecimal(40)));
        cart.addItem(new CartItem(1,"java",2,new BigDecimal(20),new BigDecimal(40)));
        cart.addItem(new CartItem(2,"java2",2,new BigDecimal(20),new BigDecimal(40)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clean() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",2,new BigDecimal(20),new BigDecimal(40)));
        cart.addItem(new CartItem(1,"java",2,new BigDecimal(20),new BigDecimal(40)));
        cart.addItem(new CartItem(2,"java2",2,new BigDecimal(20),new BigDecimal(40)));
        cart.clean();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",2,new BigDecimal(20),new BigDecimal(40)));
        cart.addItem(new CartItem(1,"java",2,new BigDecimal(20),new BigDecimal(40)));
        cart.addItem(new CartItem(2,"java2",2,new BigDecimal(20),new BigDecimal(40)));
        cart.updateCount(1,5);
        System.out.println(cart);
    }
}