package com.intertec.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * This class represents the Users entity. Only have one field: 'username'.
 *
 * */
@Entity
@Table(name = "int_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Constraints: valid usernames must have at least 6 character.
     * There is not a max constraint required. Configured default google standards
     * It must be unique.
     */
    @Size(min = 6, max = 64)
    @Column(nullable = false, unique = true)
    private String username;

    protected User() {
        // default constructor only exists for the sake of JPA
    }

    public User(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("user: { id:%d, username:'%s' }", id, username);
    }
}
