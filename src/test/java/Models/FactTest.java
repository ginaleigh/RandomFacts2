package Models;
import com.example.randomfacts2.model.Fact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactTest {

    @Test
    public void testFact() {
        Fact fact = new Fact(1, "This is a fact");
        assertEquals(1, fact.i());
        assertEquals("This is a fact", fact.fact());
    }

    @Test
    public void testFactEquality() {
        Fact fact1 = new Fact(1, "This is a fact");
        Fact fact2 = new Fact(1, "This is a fact");
        assertEquals(fact1, fact2);
    }

    @Test
    public void testFactToString() {
        Fact fact = new Fact(1, "This is a fact");
        assertEquals("Fact[i=1, fact=This is a fact]", fact.toString());
    }
}
