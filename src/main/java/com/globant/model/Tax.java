package com.globant.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Tax {
    private String country;
    private String dni;

    public Tax(){
        super();
    }

    public Tax(String country, String dni) {
        this.country = country;
        this.dni = dni;
    }
}
