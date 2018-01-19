package com.globant.util;

public enum EnumPlataform {
    ANDROID("Android"), IOS("iOS");

    private String os;

    EnumPlataform(String os) {
        this.os = os;
    }

    public String getOS() {
        return os;
    }
}
