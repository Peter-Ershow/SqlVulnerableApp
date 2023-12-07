package com.example.sqlvulnerableapp.repo;


import javax.persistence.*;

@Entity
@Table(name = "user_entity")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;


    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserEntity() {
    }
}

