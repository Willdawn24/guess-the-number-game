package draw.core.model;

import java.util.*;

public class Line extends AbstractElementImpl{
    private boolean vertical;
    private int length;

    public Line(int length, boolean vertical) throws IllegalArgumentException {
        this.vertical = vertical;
        this.length = length;
        if (!checkConstructorArgs())
            throw new IllegalArgumentException("Invalid coordinates for Line");
    }

    @Override
    protected boolean checkConstructorArgs() {
        boolean result = true;
        if(length==0)
            result = false;
        return result;
    }

    @Override
    public boolean commit(Canvus canvus, Coordinate coordinate){
        boolean result = true;
        if(!canvus.checkCordinateValidity(coordinate))
            result = false;
        else{
            if (!canvus.checkCordinateValidity(coordinate.offset(length, vertical)))
                result = false;
        }
        if(result)
            for(int i=0;i<length;i++){
                canvus.getPoint(coordinate.offset(i, vertical)).setCharacter('X');
            }
        return result;
    }
}
