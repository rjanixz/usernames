package com.intertec.repository;

import com.intertec.domain.RestrictedWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrictedWordRepository extends JpaRepository<RestrictedWord, Long> {

}
