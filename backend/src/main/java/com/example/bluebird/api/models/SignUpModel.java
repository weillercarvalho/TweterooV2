package com.example.bluebird.api.models;

import com.example.bluebird.api.dto.SignUpDTO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Signup")
public class SignUpModel {

    public SignUpModel(SignUpDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 255, nullable = false)
    private String username;
    @Column(length = 255, nullable = false)
    private String avatar;
}
