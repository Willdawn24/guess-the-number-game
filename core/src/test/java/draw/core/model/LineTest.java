package draw.core.model;

import draw.core.DrawImpl;
import draw.core.IDraw;
import draw.core.model.Line;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class LineTest {
    @Test
    public void checkLineConstructor(){
        Assertions.assertAll(()->{
            Line line = new Line(2, false);
        });
    }
    @Test
    public void checkLineConstructor2(){
        Assertions.assertAll(()->{
            Line line = new Line(2, true);
        });
    }
    @Test
    public void testCheckConstructorWithInvalidArgs1() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Line(1,true);});
    }
    @Test
    public void testCheckConstructorWithInvalidArgs2() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Line(0,true);});
    }

    @Test
    public void testCheckConstructorInvalidArgs3() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Line(-1,true);});
    }
    @Test
    public void testCheckConstructorArgs() {
        Line line1 = null;
        line1 = new Line(2, true);
        assertTrue(line1!=null);
    }

    @Test
    public void commit() {
        Assertions.assertAll(()->{
            DisplayableCanvus displayableCanvus= new DisplayableCanvus(4,4);
            Line line = new Line(2,true);
            Coordinate coordinate = new Coordinate(1,1);
            line.commit(displayableCanvus, coordinate);
            assertEquals('x',displayableCanvus.getChar(coordinate));
            assertEquals('x',displayableCanvus.getChar(coordinate.offset(1,true)));
        });
    }


}