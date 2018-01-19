package com.globant.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globant.model.User;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

public class MapperJSON {

    public static <T> List<T> getObjects(Class<T> tClass, String file) throws IOException {
        return new ObjectMapper().readValue(
                new ClassPathResource(file).getInputStream(),
                new ObjectMapper().getTypeFactory().constructCollectionType(List.class, tClass));
    }

    /**
     * Get a specific user
     *
     * @param name
     * @return An user of {@link User}
     */
    public static User getUser(String name) throws IOException {
        return getObjects(User.class, EnumData.USERS.getFile()).stream()
                .filter(user -> user.getName().equals(name))
                .findAny().get();
    }
}
