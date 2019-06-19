package draw.core.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void checkConstructorArgsTest() {
        Rectangle rect = null;
        rect = new Rectangle(2,2);
        assertTrue(!rect.equals(null));
    }

    @Test
    public void checkConstructorInvalidArgsTest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Rectangle(0,1);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Rectangle(-1,-1);});
    }


    @Test
    public void commit() {
    }
}