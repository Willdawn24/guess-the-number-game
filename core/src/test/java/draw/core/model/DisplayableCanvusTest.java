package draw.core.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class DisplayableCanvusTest {
    DisplayableCanvus displayableCanvus;
    Coordinate cdntInside, cdntOnBoundary, cdntOnCorner, cdntOutside, cdntOnBoundary2;

    @Before
    public void setUp() throws Exception {
        displayableCanvus = new DisplayableCanvus(10,10);

        cdntInside = new Coordinate(5,5);
        cdntOnBoundary = new Coordinate(5,0);
        cdntOnCorner = new Coordinate(0,0);
        cdntOutside = new Coordinate(14,7);
        cdntOnBoundary2 = new Coordinate(0,7);
    }

    @Test
    public void testConstructorWithZeroWidth(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
           displayableCanvus = new DisplayableCanvus(0,10);
        });
    }
    @Test
    public void testConstructorWithZeroHeight(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            displayableCanvus = new DisplayableCanvus(10,0);
        });
    }
    @Test
    public void testConstructorWithNegativeHeight(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            displayableCanvus = new DisplayableCanvus(10,-10);
        });
    }
    @Test
    public void testConstructorWithPositiveArgs(){
        Assertions.assertAll(()->{
            displayableCanvus = new DisplayableCanvus(10,10);
        });
    }
    @Test
    public void testCommit() {
        Coordinate coordinate = new Coordinate(5,5);
        char old = displayableCanvus.getChar(coordinate);
        char c = 'A';
        displayableCanvus.commit(coordinate,c);
        assertEquals(c, displayableCanvus.getChar(coordinate));
        assertTrue(old!=displayableCanvus.getChar(coordinate));
    }

    @Test
    public void testCheckCoordinateValidity() {
        assertFalse(displayableCanvus.checkCoordinateValidity(cdntOnCorner));
        assertFalse(displayableCanvus.checkCoordinateValidity(cdntOnBoundary));
        assertFalse(displayableCanvus.checkCoordinateValidity(cdntOutside));
        assertTrue(displayableCanvus.checkCoordinateValidity(cdntInside));
    }

    @Test
    public void testIsOnBoundary() {
        assertTrue(displayableCanvus.isOnBoundary(cdntOnBoundary));
        assertTrue(displayableCanvus.isOnBoundary(cdntOnCorner));
        assertFalse(displayableCanvus.isOnBoundary(cdntInside));
        assertFalse(displayableCanvus.isOnBoundary(cdntOutside));
    }

    @Test
    public void testIsInside() {
        assertFalse(displayableCanvus.isInside(cdntOnBoundary));
        assertFalse(displayableCanvus.isInside(cdntOnCorner));
        assertTrue(displayableCanvus.isInside(cdntInside));
        assertFalse(displayableCanvus.isInside(cdntOutside));
    }

    @Test
    public void testIsOnVerticalBoundary() {
        assertFalse(displayableCanvus.isOnVerticalBoundary(cdntOnBoundary));
        assertTrue(displayableCanvus.isOnVerticalBoundary(cdntOnCorner));
        assertFalse(displayableCanvus.isOnVerticalBoundary(cdntInside));
        assertFalse(displayableCanvus.isOnVerticalBoundary(cdntOutside));
        assertTrue(displayableCanvus.isOnVerticalBoundary(cdntOnBoundary2));
    }

    @Test
    public void testIsOnHorizontalBoundary() {
        assertTrue(displayableCanvus.isOnHorizontalBoundary(cdntOnBoundary));
        assertTrue(displayableCanvus.isOnHorizontalBoundary(cdntOnCorner));
        assertFalse(displayableCanvus.isOnHorizontalBoundary(cdntInside));
        assertFalse(displayableCanvus.isOnHorizontalBoundary(cdntOutside));
        assertFalse(displayableCanvus.isOnHorizontalBoundary(cdntOnBoundary2));

    }

    @Test
    public void testGetWidth(){

        assertEquals(12, displayableCanvus.getWidth());
    }

    @Test
    public void testGetHeight(){

        assertEquals(12, displayableCanvus.getHeight());
    }

    @Test
    public void testDisplay(){
        Assertions.assertAll(()->{
            displayableCanvus.display();
        });
    }
    @Test
    public void fill() {
        char c = 'M';
        displayableCanvus.fill(new Coordinate(5,5), c);
        for(int i =0; i< displayableCanvus.getHeight();i++){
            for(int j = 0;j<displayableCanvus.getWidth();j++){
                Coordinate cdnt = new Coordinate(j,i);
                if (displayableCanvus.isInside(cdnt))
                    assertEquals(c, displayableCanvus.getChar(new Coordinate(j,i)));
            }
        }
    }
    @Test
    public void testToString(){
        String string = displayableCanvus.toString();
        assertTrue(string.contains("width"));
        assertTrue(string.contains("height"));
    }
}