package com.springjiemi.ioc;

/**
 * @author yanwu233
 * @date 2019/2/21 14:49
 **/
public interface IFXNewsListener {
    String[] getAvaliableNewsIds();

    FXNewsBean getNewsByPK(String newsId);

    void postProcessIfNecessary(String newsId);
}
