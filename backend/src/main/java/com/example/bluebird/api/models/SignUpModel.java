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
    
    public SignUpModel(int id, String username, String avatar) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
    }

    public SignUpModel(SignUpDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 255, nullable = false)
    private String username;
    @Column(length = 255, nullable = false)
    private String avatar;
}
