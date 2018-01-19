package com.globant.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Simple POJO that represents a User.
 */
@Getter
@Setter
public class User {

    private String accountRUT;
    private String accountSerialNumber;
    private String name;
    private String lastName;
    private String cellNumber;
    private String email;
    private String comment;

    public String getFullName() {
        return new StringBuffer()
                .append(name)
                .append(" ")
                .append(lastName)
                .toString();
    }

    @Override
    public String toString() {
        return "User [accountRUT=" + accountRUT + ", accountSerialNumber=" + accountSerialNumber + ", name=" + name
                + ", lastName=" + lastName + ", cellNumber=" + cellNumber + ", email=" + email + "]";
    }
}
