package com.springjiemi.ioc.fxsystem;

import com.springjiemi.ioc.fxsystem.FXNewsBean;
import com.springjiemi.ioc.fxsystem.IFXNewsPersister;
import org.springframework.stereotype.Component;

/**
 * @author yanwu233
 * @date 2019/2/21 15:46
 **/
@Component
public class DowJonesNewsPersister implements IFXNewsPersister {
    @Override
    public void persistNews(FXNewsBean newsBean) {

    }
}
