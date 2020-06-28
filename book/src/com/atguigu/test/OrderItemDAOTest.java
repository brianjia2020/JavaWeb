package com.atguigu.test;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.OrderItemDAOImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDAOTest {

    @Test
    public void saveOrderItem() {
        OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
        orderItemDAO.saveOrderItem(new OrderItem(null,"java",1,new BigDecimal(10),new BigDecimal(10),"123456"));
    }
}