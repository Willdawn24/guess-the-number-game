package draw.core.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Line extends AbstractElementImpl{
    private boolean vertical;
    private int length;

    public Line(int length, boolean vertical) throws IllegalArgumentException {
        this.vertical = vertical;
        this.length = length;
        if (!checkConstructorArgs())
            throw new IllegalArgumentException("Invalid coordinates for Line");
        log.info("create line: "+this.toString());
    }

    @Override
    protected boolean checkConstructorArgs() {
        boolean result = true;
        if(length<=1 && length>=-1)
            result = false;
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "vertical=" + vertical +
                ", length=" + length +
                '}';
    }

    @Override
    public boolean commit(IDisplayable iDisplayable, Coordinate coordinate){
        log.debug("commit line {} at coordinate: {}", this, coordinate.toString());
        boolean result = true;
        int sign;
        sign = length>0 ?1:-1;
        Coordinate endCoordinate = coordinate.offset(length-1, vertical);
        result = iDisplayable.checkCoordinateValidity(coordinate)&& iDisplayable.checkCoordinateValidity(endCoordinate);
        log.info("check coordinate {}", coordinate);
        log.info("and check end cooordinate {}", endCoordinate);
        if(result)
            for(int i=0;i<Math.abs(length);i++){
                iDisplayable.commit(coordinate.offset(i*sign, vertical),'x');
            }
        return result;

    }
}
