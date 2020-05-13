package com.atguigu.test;


import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

public class JDBCUtilsTest {
    @Test
    public void testJDBCUtils(){
        System.out.println(JDBCUtils.getConnection());
    }
}
