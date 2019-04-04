package com.springjiemi.ioc.applicationcontext.UniformResourceLoadingStrategy;

import org.springframework.core.io.Resource;

/**
 * @author yanwu233
 * @date 2019/3/25 14:18
 **/
public class XMailer {
    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "XMailer{" +
                "resource=" + resource +
                '}';
    }
}
