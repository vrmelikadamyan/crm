package com.tucanoo.crm.data.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserInfo extends User {
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String firstName;
    private String lastName;

    public UserInfo(
            String userName,
            String firstName,
            String lastName,
            String role,
            String password,
            PasswordEncoder passwordEncoder
    ) {
        super(userName, passwordEncoder.encode(password), List.of(new SimpleGrantedAuthority(role)));
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
