package com.atguigu.utils;

import com.atguigu.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebUtils {
    public static <T>T copyParamToBean(Map value, T bean){
        try{
            BeanUtils.populate(bean,value);
            System.out.println(bean);
        } catch (Exception e){
            System.out.println(e);
        }
        return bean;
    }

}
