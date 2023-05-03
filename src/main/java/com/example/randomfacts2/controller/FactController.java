package com.example.randomfacts2.controller;

import com.example.randomfacts2.model.Fact;
import com.example.randomfacts2.service.FactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FactController {
    private final FactService factService;

    public FactController(FactService factService) {
        this.factService = factService;
    }

    @GetMapping("/facts")
    public Mono<List<Fact>> getFacts() {
        return factService.getSingleFact();
    }

    @GetMapping("/facts/{limitValue}")
    public Mono<List<Fact>> getFacts(@PathVariable Integer limitValue) {
        return factService.getFacts(limitValue);
    }
}