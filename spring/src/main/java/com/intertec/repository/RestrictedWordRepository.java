package com.intertec.repository;

import com.intertec.domain.RestrictedWord;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Cacheable
public interface RestrictedWordRepository extends JpaRepository<RestrictedWord, Long> {

    // Overriding this to allow cache
    @CachePut(value="restrictedWords")
    List<RestrictedWord> findAll();
}
