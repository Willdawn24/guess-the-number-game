package draw.core.model;

import java.util.*;

public class Rectangle extends ShapeImpl{
    int width, height;

    public Rectangle(int width, int height) throws IllegalArgumentException {
        this.height = height;
        this.width = width;
        if (!checkConstructorArgs())
            throw new IllegalArgumentException("Invalid coordinates for Line");
    }

    @Override
    protected boolean checkConstructorArgs() {
        boolean result = true;
        if(width==0 && height==0)
            result = false;
        return result;
    }

    @Override
    public boolean commit(Canvus canvus, Coordinate coordinate) {
        // lowerleft coordinate
        boolean result;
        result = canvus.checkCordinateValidity(coordinate) && canvus.checkCordinateValidity(coordinate.offset(width, true).offset(height, false));
        if (result){
            for (int i = 0;i<height;i++)
                canvus.getPoint(coordinate.offset(i,true)).setCharacter('X');
            for (int i = 0;i<height;i++)
                canvus.getPoint(coordinate.offset(width, false).offset(i, true)).setCharacter('X');
            for (int i = 0;i<width;i++)
                canvus.getPoint(coordinate.offset(i,false)).setCharacter('X');
            for (int i = 0;i<width;i++)
                canvus.getPoint(coordinate.offset(height, true).offset(i, false)).setCharacter('X');
        }

        return result;
    }


}
