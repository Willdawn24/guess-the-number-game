package draw.core.model;


import draw.core.DrawImpl;
import draw.core.IDraw;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class PointTest {
    private Point point;

    @Before
    public void before(){
        point = new Point();
    }

    @After
    public void after(){
        point = null;
    }

    @Test
    public void setCharacterTest() {
        assertTrue(point.getCharacter() == ' ');
        char c = '.';
        point.setCharacter(c);
        assertTrue(point.getCharacter() == c);
    }

    @Test
    public void testGetCharacter() {
        assertTrue(point.getCharacter() == ' ');
    }

    @Test
    public void testCheckConstructorArgs() {
        assertTrue(point.checkConstructorArgs());
    }

    @Test
    public void toStringTest() {
        assertTrue(point.toString().contains(" "));
    }

    @Test
    public void commit() {
        Assertions.assertAll(()->{
            DisplayableCanvus displayableCanvus = new DisplayableCanvus(4,4);
            Point point = new Point();
            Coordinate coordinate = new Coordinate(1,1);
            point.commit(displayableCanvus, coordinate);
            assertEquals(' ', displayableCanvus.getChar(coordinate));
        });
    }
}