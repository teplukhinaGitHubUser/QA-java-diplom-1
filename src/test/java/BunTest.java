import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import praktikum.Bun;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BunTest {
    Bun bun;

    @BeforeEach
    public void setUp() {
        bun = new Bun("test name", 12.12f);
    }

    @Test
    public void getName() {
        assertEquals("test name", bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(12.12f, bun.getPrice(),0.0);
    }
}
