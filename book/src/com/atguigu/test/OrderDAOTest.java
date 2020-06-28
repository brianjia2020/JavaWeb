package com.atguigu.test;

import com.atguigu.bean.Order;
import com.atguigu.dao.OrderDAO;
import com.atguigu.dao.impl.OrderDAOImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDAOTest {
    @Test
    public void saveOrder(){
        OrderDAO orderDAO = new OrderDAOImpl();
        orderDAO.saveOrder(new Order("123456",new Date(),new BigDecimal(100),0,1));
    }

}