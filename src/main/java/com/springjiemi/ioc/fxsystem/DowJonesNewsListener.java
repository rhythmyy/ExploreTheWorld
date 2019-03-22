package com.springjiemi.ioc.fxsystem;

import com.springjiemi.ioc.BeanPostProcessor.PasswordDecodable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yanwu233
 * @date 2019/2/21 15:43
 **/
@Component
public class DowJonesNewsListener implements IFXNewsListener , PasswordDecodable {

    @Value("password")
    private String password;

    @Override
    public String[] getAvaliableNewsIds() {
        return new String[0];
    }

    @Override
    public FXNewsBean getNewsByPK(String newsId) {
        return null;
    }

    @Override
    public void postProcessIfNecessary(String newsId) {

    }

    @Override
    public String getEncodedPassword() {
        return password;
    }

    @Override
    public void setDecodedPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DowJonesNewsListener{" +
                "password='" + password + '\'' +
                '}';
    }
}
