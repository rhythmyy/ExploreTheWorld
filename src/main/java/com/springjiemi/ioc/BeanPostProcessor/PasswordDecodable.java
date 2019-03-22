package com.springjiemi.ioc.BeanPostProcessor;

/**
 * @author yanwu233
 * @date 2019/3/19 15:01
 **/
public interface PasswordDecodable {
    String getEncodedPassword();

    void setDecodedPassword(String password);
}
