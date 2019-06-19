package draw.core.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testCheckConstructorArgs() {
        Rectangle rect = null;
        rect = new Rectangle(2,2);
        assertTrue(!rect.equals(null));
    }

    @Test
    public void testCheckConstructorWithZeroWidth() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->{new Rectangle(0,1);});
    }
    @Test
    public void testCheckConstructorWithZeroHeight() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->{new Rectangle(2,0);});
    }
    @Test
    public void testCheckConstructorWithNegativeArgs() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->{new Rectangle(-1,-1);});
    }

    @Test
    public void testCommit() {
        Assertions.assertAll(()->{
            DisplayableCanvus displayableCanvus= new DisplayableCanvus(4,4);
            Rectangle rectangle = new Rectangle(2,2);
            Coordinate coordinate = new Coordinate(1,1);
            rectangle.commit(displayableCanvus, coordinate);
            assertEquals('x',displayableCanvus.getChar(coordinate));
            assertEquals('x',displayableCanvus.getChar(coordinate.offset(1,true)));
            assertEquals('x',displayableCanvus.getChar(coordinate.offset(1,false)));
            assertEquals('x',displayableCanvus.getChar(coordinate.offset(1,false).offset(1,true)));
        });
    }

    @Test
    public void testIsOnBoundary(){
        Coordinate coordinate = new Coordinate(1,1);
        Rectangle rectangle = new Rectangle(4,4);
        assertFalse(rectangle.isOnBoundary(coordinate));
    }

    @Test
    public void testIsInside(){
        Coordinate coordinate = new Coordinate(1,1);
        Rectangle rectangle = new Rectangle(4,4);
        assertFalse(rectangle.isInside(coordinate));
    }

    @Test
    public void testIsOutside(){
        Coordinate coordinate = new Coordinate(1,1);
        Rectangle rectangle = new Rectangle(4,4);
        assertTrue(rectangle.isOutside(coordinate));
    }
}