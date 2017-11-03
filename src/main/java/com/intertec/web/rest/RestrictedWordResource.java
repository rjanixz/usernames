package com.intertec.web.rest;

import com.intertec.domain.RestrictedWord;
import com.intertec.repository.RestrictedWordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestrictedWordResource {

    private Logger LOGGER = LoggerFactory.getLogger(RestrictedWordResource.class);

    private RestrictedWordRepository restrictedWordRepository;

    public RestrictedWordResource(RestrictedWordRepository restrictedWordRepository) {
        this.restrictedWordRepository = restrictedWordRepository;
    }

    @GetMapping("/restricted-words")
    public List<RestrictedWord> getAllRestrictedWords() {
        return restrictedWordRepository.findAll();
    }
}
