package org.example;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NumberController {
    private final NumberRepository numberRepository;
    public NumberController(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }
    @GetMapping(path = "/allNumbers")
    public List<Number> getAllNumbers() {
        return numberRepository.findAll();
    }
}
