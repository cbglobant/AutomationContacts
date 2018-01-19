package com.globant.util;

import com.globant.model.User;

public enum EnumData {

    USERS("Users.json", User.class);

    private String file;
    private Class<?> aClass;


    EnumData(String nameDriver, Class aClass) {
        this.file = nameDriver;
        this.aClass = aClass;
    }

    public String getFile() {
        return file;
    }

    public Class<?> getaClass() {
        return aClass;
    }
}
