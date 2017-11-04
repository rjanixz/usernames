package com.intertec.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "int_restricted_words")
public class RestrictedWord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String word;

    protected RestrictedWord() {
        // default constructor only exists for the sake of JPA
    }

    public RestrictedWord(String word) {
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return String.format("restricted_word: { id:%d, word:'%s' }", id, word);
    }
}
