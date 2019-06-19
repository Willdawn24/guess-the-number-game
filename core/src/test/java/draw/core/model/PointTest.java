package draw.core.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import javax.annotation.PreDestroy;

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
    public void getCharacterTest() {
        assertTrue(point.getCharacter() == ' ');
    }

    @Test
    public void checkConstructorArgsTest() {
        assertTrue(point.checkConstructorArgs());
    }

    @Test
    public void toStringTest() {
        assertTrue(point.toString().contains(" "));
    }

    @Test
    public void commit() {
    }
}