package com.cf.cash_flow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    @NotBlank
    @Email(message = "Invalid e-mail")
    private String email;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 150)
    private String name;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(max = 150)
    private String password;
}