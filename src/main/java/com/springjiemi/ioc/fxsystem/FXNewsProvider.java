package com.springjiemi.ioc.fxsystem;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yanwu233
 * @date 2019/2/21 14:47
 **/
@Component
public class FXNewsProvider {
    @Autowired
    IFXNewsListener newsListener;

    @Autowired
    IFXNewsPersister newsPersister;

    public FXNewsProvider() {

    }


    public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersister newsPersister) {
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }

    public void getAndPersistNews() {
        System.out.println("getAndPersistNews");
        String[] newsIds = newsListener.getAvaliableNewsIds();
        if (ArrayUtils.isEmpty(newsIds)) {
            return;
        }

        for (String newsId :
                newsIds) {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newsPersister.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        }
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public void setNewsPersister(IFXNewsPersister newsPersister) {
        this.newsPersister = newsPersister;
    }

    public IFXNewsListener getNewsListener() {
        return newsListener;
    }

    public IFXNewsPersister getNewsPersister() {
        return newsPersister;
    }
}

