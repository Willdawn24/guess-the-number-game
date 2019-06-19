package draw.core.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Point extends AbstractElementImpl implements ICommitable {
    private char character = ' ';

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
    public String toString() {
        return "Point{" +
                "character=" + character +
                '}';
    }

    @Override
    public boolean commit(IDisplayable displayable, Coordinate coordinate) throws IllegalArgumentException{
        log.debug("Create Point {} at coordiate {}", this, coordinate);
        boolean result = displayable.checkCoordinateValidity(coordinate);
        displayable.commit(coordinate,character);
        return result;
    }


}
