package Controllers;
import com.example.randomfacts2.controller.FactController;
import com.example.randomfacts2.model.Fact;
import com.example.randomfacts2.service.FactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class FactControllerTest {
    private FactController factController;

    @Mock
    private FactService factService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        factController = new FactController(factService);
    }

    @Test
    void testGetFacts() {
        List<Fact> facts = Arrays.asList(
                new Fact(1, "Fact 1"),
                new Fact(2, "Fact 2")
        );

        when(factService.getSingleFact()).thenReturn(Mono.just(facts));

        StepVerifier.create(factController.getFacts())
                .expectNext(facts)
                .expectComplete()
                .verify();
    }
    @Test
    void testGetFactsWithLimit() {
        List<Fact> facts = Arrays.asList(
                new Fact(1, "Fact 1"),
                new Fact(2, "Fact 2")
        );

        int limit = 2;

        when(factService.getFacts(limit)).thenReturn(Mono.just(facts));

        StepVerifier.create(factController.getFacts(limit))
                .expectNext(facts)
                .expectComplete()
                .verify();
    }
}
