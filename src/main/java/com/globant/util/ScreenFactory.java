package com.globant.util;

import com.globant.pageobject.BaseScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ScreenFactory {

    @Autowired
    private ApplicationContext appContext;

    public <T> T getScreen(Class<T> aClass) {
        return appContext.getBean((Class<T>) aClass.getClass());
    }

    public <T extends BaseScreen> T getScreen(String nameBean) {
        return (T) appContext.getBean(nameBean);
    }
}
