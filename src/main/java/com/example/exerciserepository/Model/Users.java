package com.example.exerciserepository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "name can not be null")
    @Length(min = 4,message = "name Length must be more than 4")
    private String name;

    @Column(columnDefinition = "varchar(20) not null unique")
    @NotNull(message = "username can not be null")
    @Length(min = 4,message = "username Length must be more than 4")
    private String username;

    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "password can not be null")
    private String password;


    @Column(columnDefinition = "varchar(20) not null unique")
    @NotNull(message = "email can not be null")
    @Email(message = "must be valid email ")
    private String email;

    //@Column(columnDefinition = "varchar not null check(role='user' or role='admin')")
    @NotNull(message = "role can not be null")
    @Pattern(regexp = "^(user|admin)$", message = "Role must be either 'user' or 'admin'")
     private String role;

    @Column(columnDefinition = "int not null")
    @Positive
    @NotNull(message = "age can not be null")
     private int age;
}
