package com.metanet.webfluxpractice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class ApiService {
    private final   WebClient   webClient;

    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://api.example.com").build();
    }

    public Mono<String> getExampleData() {
        return this.webClient.get()
                .uri("/data")
                .retrieve()
                .bodyToMono(String.class);
    }
}
