import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {

    @Test
    public void shouldReturnCorrectName() {
        Bun bun = new Bun("wholegrain", 1f);
        assertEquals("wholegrain", bun.getName());
    }

    @Test
    public void shouldReturnCorrectPrice() {
        Bun bun = new Bun("wholegrain", 1f);
        assertEquals(1f, bun.getPrice(),0.001f);
    }
}