package com.example.securitydemo.Domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {
    @Id
    @Column
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String role;
}
