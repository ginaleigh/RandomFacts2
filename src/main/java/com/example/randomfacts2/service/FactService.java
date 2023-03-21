package com.example.randomfacts2.service;

import com.example.randomfacts2.model.Fact;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class FactService {
    private final WebClient webClient;
    private final ServiceConfig config;
    public FactService(ServiceConfig config) {
        this.config = config;
        this.webClient = WebClient.create();
    }

    public List<Fact> getSingleFact() {
        return webClientCall(Optional.empty());
    }

    public List<Fact> getFacts(Integer limitValue) {
        if (limitValue != null && limitValue > 0 && limitValue < 100) {
            return webClientCall(Optional.of(limitValue));
        }
        return null;
    }

    private List<Fact> webClientCall(Optional<Integer> limitValue) {
        // https://api.api-ninjas.com/v1/facts
        return webClient.get()
                .uri(uriBuilder1 -> uriBuilder1.scheme("https").host("api.api-ninjas.com").path("v1/facts").queryParamIfPresent("limit", limitValue).build())
                .header("X-Api-Key", config.apiKey)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Fact>>() {
                })
                .block();
    }
}
