package draw.core.model;

import draw.core.model.Coordinate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {
    private Coordinate coordinate;

    @Before
    public void before(){
        coordinate = new Coordinate(2,2);
    }

    @Test
    public void testGetxCoordinate() {
        assertEquals(2, coordinate.getxCoordinate());
    }

    @Test
    public void testGetyCoordinate() {
        assertEquals(2, coordinate.getyCoordinate());
    }

    @Test
    public void testEqualsWithSameCoordinates() {
        Coordinate cdnt2 = new Coordinate(2,2);
        assertTrue(coordinate.equals(cdnt2));
    }
    @Test
    public void testEqualsWithDifferentXcoordinate() {
        Coordinate cdnt2 = new Coordinate(3,2);
        assertFalse(coordinate.equals(cdnt2));
    }
    @Test
    public void testEqualsWithDifferentYcoordinate() {
        Coordinate cdnt2 = new Coordinate(2,3);
        assertFalse(coordinate.equals(cdnt2));
    }
    @Test
    public void testEqualsWithDifferentCoordinates() {
        Coordinate cdnt2 = new Coordinate(1,1);
        assertFalse(coordinate.equals(cdnt2));
    }

    @Test
    public void testVerticalOffset() {
        Coordinate target = new Coordinate(2,4);
        assertTrue(coordinate.offset(2,true).equals(target));
    }
    @Test
    public void testHorizontalOffset() {
        Coordinate target = new Coordinate(4,2);

        assertTrue(coordinate.offset(2,false).equals(target));
    }
    @Test
    public void testBothCoordinateOffset() {
        Coordinate target = new Coordinate(0,0);
        assertTrue(coordinate.offset(-2,true).offset(-2,false).equals(target));
    }

    @Test
    public void testToString(){
        assertTrue(coordinate.toString().contains(String.valueOf(coordinate.getxCoordinate())));
    }
}