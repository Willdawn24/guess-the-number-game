package draw.core.model;

import java.util.*;

public class Point extends AbstractElementImpl implements IDisplayable {
    private char character = ' ';

    public Point() throws IllegalArgumentException{
        super();
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    protected boolean checkConstructorArgs() {
        return true;
    }

    @Override
    public boolean commit(Canvus canvus, Coordinate coordinate) throws IllegalArgumentException{
        boolean result = canvus.checkCordinateValidity(coordinate);
        canvus.getPoint(coordinate).setCharacter(character);
        return result;
    }


}
