package com.metanet.webfluxpractice;

import com.metanet.webfluxpractice.controller.ApiController;
import com.metanet.webfluxpractice.service.ApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;

@WebFluxTest(ApiController.class)
public class ApiControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private ApiService  apiService;

    @Test
    public void testGetData() {
        String  expectedResponse = "example data";

        given(apiService.getExampleData()).willReturn(Mono.just(expectedResponse));
        webTestClient.get().uri("/api/data")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo(expectedResponse);
    }
}
