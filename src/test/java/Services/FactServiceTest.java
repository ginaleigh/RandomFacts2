//package Services;
//import com.example.randomfacts2.model.Fact;
//import com.example.randomfacts2.service.FactService;
//import com.example.randomfacts2.service.ServiceConfig;
//import org.junit.jupiter.api.Test;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.web.reactive.function.client.ExchangeFunction;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class FactServiceTest {
//    private static final String BASE_URI = "https://api.api-ninjas.com";
//    private static final String FACTS_PATH = "/v1/facts";
//
//    private final ServiceConfig serviceConfig = new ServiceConfig("testApiKey");
//    private final WebClient webClient = mock(WebClient.class);
//    private final ExchangeFunction exchangeFunction = mock(ExchangeFunction.class);
//
//    private final FactService factService = new FactService(serviceConfig, webClient);
//
//    @Test
//    void getSingleFact_shouldReturnSingleFact() {
//        Fact expectedFact = new Fact(1, "Test Fact");
//        when(webClient.get()).thenReturn(webClient);
//        when(webClient.uri(any())).thenReturn(webClient);
//        when(webClient.header(any(), any())).thenReturn(webClient);
//        when(webClient.retrieve()).thenReturn(mock(WebClient.ResponseSpec.class));
//        when(webClient.retrieve().bodyToMono(any(ParameterizedTypeReference.class)))
//                .thenReturn(Mono.just(List.of(expectedFact)));
//
//        Mono<List<Fact>> result = factService.getSingleFact();
//
//        StepVerifier.create(result)
//                .expectNext(List.of(expectedFact))
//                .verifyComplete();
//    }
//    @Test
//    void getFacts_withValidLimit_shouldReturnFactsWithLimit() {
//        int limit = 10;
//        Fact expectedFact = new Fact(1, "Test Fact");
//        when(webClient.get()).thenReturn(webClient);
//        when(webClient.uri(any())).thenReturn(webClient);
//        when(webClient.header(any(), any())).thenReturn(webClient);
//        when(webClient.retrieve()).thenReturn(mock(WebClient.ResponseSpec.class));
//        when(webClient.retrieve().bodyToMono(any(ParameterizedTypeReference.class)))
//                .thenReturn(Mono.just(List.of(expectedFact)));
//
//        Mono<List<Fact>> result = factService.getFacts(limit);
//
//        StepVerifier.create(result)
//                .expectNext(List.of(expectedFact))
//                .verifyComplete();
//    }
//    @Test
//    void getFacts_withNullLimit_shouldReturnEmptyMono() {
//        Integer limit = null;
//
//        Mono<List<Fact>> result = factService.getFacts(limit);
//
//        StepVerifier.create(result)
//                .expectNextCount(0)
//                .verifyComplete();
//    }
//
//    @Test
//    void getFacts_withZeroLimit_shouldReturnEmptyMono() {
//        int limit = 0;
//
//        Mono<List<Fact>> result = factService.getFacts(limit);
//
//        StepVerifier.create(result)
//                .expectNextCount(0)
//                .verifyComplete();
//    }
//
//    @Test
//    void getFacts_withLimitOver100_shouldReturnEmptyMono() {
//        int limit = 101;
//
//        Mono<List<Fact>> result = factService.getFacts(limit);
//
//        StepVerifier.create(result)
//                .expectNextCount(0)
//                .verifyComplete();
//    }
//
//}
