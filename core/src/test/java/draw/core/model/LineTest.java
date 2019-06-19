package draw.core.model;

import draw.core.model.Line;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class LineTest {

    @org.junit.Test
    public void checkConstructorInvalidArgs1() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Line(1,true);});
    }
    @org.junit.Test
    public void checkConstructorInvalidArgs2() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Line(-1,true);});
    }
    @org.junit.Test
    public void checkConstructorArgs() {
        Line line1 = null;
        line1 = new Line(2, true);
        assertTrue(line1!=null);
    }

    @org.junit.Test
    public void commit() {
    }
}