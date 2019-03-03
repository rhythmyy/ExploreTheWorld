package com.springjiemi.ioc;

import org.springframework.stereotype.Component;

/**
 * @author yanwu233
 * @date 2019/2/21 15:43
 **/
@Component
public class DowJonesNewsListener implements IFXNewsListener {
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
}
