package draw.core;

import draw.core.DrawImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrawImplTest {
    IDraw draw;

    @Before
    public void before(){
        draw = new DrawImpl();
    }

    @Test
    public void testGetDisplayable() {
        assertTrue(draw.getDisplayable(4,4));
    }
    @Test
    public void testGetDisplayableWithSize1() {
        assertTrue(draw.getDisplayable(1,1));
    }
    @Test
    public void testGetDisplayableWithZeroWidth() {
        assertFalse(draw.getDisplayable(0,4));
    }
    @Test
    public void testGetDisplayableWithZeroHeight() {
        assertFalse(draw.getDisplayable(4,0));
    }
    @Test
    public void testGetDisplayableWithNegativeWidth() {
        assertFalse(draw.getDisplayable(-3,3));
    }
    @Test
    public void testGetDisplayableWithNegativeHeight() {
        assertFalse(draw.getDisplayable(3,-3));
    }

    @Test
    public void testGetVerticalLine() {
        draw.getDisplayable(5,5);
        assertTrue(draw.getLine(1,1,3,1));
    }
    @Test
    public void testGetHorizontalLine() {
        draw.getDisplayable(4,4);
        assertTrue(draw.getLine(1,1,1,3));
    }

    @Test
    public void testGetDiagonalLine() {
        draw.getDisplayable(10,10);
        assertFalse(draw.getLine(1,1,10,10));
    }
    @Test
    public void testGetLineOutsideCanvus1() {
        draw.getDisplayable(10,10);
        assertFalse(draw.getLine(1,1,11,1));
    }
    @Test
    public void testGetLineOutsideCanvus2() {
        draw.getDisplayable(4,4);
        assertFalse(draw.getLine(-1,1,1,1));
    }

    @Test
    public void getLineWithInvalidArgs1() {
        draw.getDisplayable(10,10);
        assertFalse(draw.getLine(3,3,3,2));
    }
    @Test
    public void getLineWithInvalidArgs2() {
        draw.getDisplayable(10,10);
        assertFalse(draw.getLine(3,3,2,3));
    }


    @Test
    public void getRectangleWithMinSize() {

        draw.getDisplayable(2,2);
        assertTrue(draw.getRectangle(1,1,2,2));
    }
    @Test
    public void getRectangleWithMaxSize() {
        draw.getDisplayable(10,10);
        assertTrue(draw.getRectangle(1,1,10,10));
    }


    @Test
    public void getRectangleInsideCanvus() {
        draw.getDisplayable(10,10);
        assertTrue(draw.getRectangle(5,5,7,7));
    }

    @Test
    public void getRectangleWithCornerOutside() {
        draw.getDisplayable(4,4);
        assertFalse(draw.getRectangle(-1,-1,2,2));
    }
    @Test
    public void getRectangleWithCornerOutside2() {
        draw.getDisplayable(4,4);
        assertFalse(draw.getRectangle(3,3,12,12));
    }
    @Test
    public void getRectangleWithValidCoordinates() {

        draw.getDisplayable(10,10);
        assertTrue(draw.getRectangle(3,3,5,8));
    }
    @Test
    public void getRectangleWithInvalidCoordinates() {

        draw.getDisplayable(10,10);
        assertFalse(draw.getRectangle(3,3,2,2));
    }
    @Test
    public void getRectangleWithInvalidCoordinates2() {
        draw.getDisplayable(5,5);
        assertFalse(draw.getRectangle(0,0,5,5));
    }
    @Test
    public void fill() {
        assertAll(()->{
           draw.getDisplayable(10,4);
           draw.getRectangle(2,2,4,4);
           draw.fill(3,3,'o');
        });
    }

    @Test
    public void display() {
        assertAll(()->{
            draw.getDisplayable(4,4);
            draw.display();
        });
    }
}