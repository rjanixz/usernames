package com.intertec.web.rest;

import com.intertec.domain.RestrictedWord;
import com.intertec.domain.User;
import com.intertec.repository.RestrictedWordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping("/restricted-words")
    public ResponseEntity<RestrictedWord> createRestrictedWord(@Valid @RequestBody RestrictedWord word) throws URISyntaxException {
        LOGGER.info("REST request to save restricted word : {} ", word);
        if(word.getId() != null) {
            return ResponseEntity.badRequest().header("Error", "Restricted Words cannot have duplicate ids").body(null);
        }

        RestrictedWord result = restrictedWordRepository.save(word);

        return ResponseEntity.created(new URI("/api/restricted-words/" + result.getId()))
                .header("Success").body(result);
    }

    @DeleteMapping("/restricted-words/{id}")
    public ResponseEntity<RestrictedWord> deleteRestrictedWord(@PathVariable Long id) {
        LOGGER.info("REST request to delete restricted word: {} ", id);
        restrictedWordRepository.delete(id);
        return ResponseEntity.ok().header("Success").build();

    }
}
