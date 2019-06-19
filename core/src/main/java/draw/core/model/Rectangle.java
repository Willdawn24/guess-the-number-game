package draw.core.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rectangle extends ShapeImpl{
    private int width, height;

    public Rectangle(int width, int height) throws IllegalArgumentException {
        this.height = height;
        this.width = width;
        if (!checkConstructorArgs())
            throw new IllegalArgumentException("Invalid coordinates for Line");
        log.info("create rectangle: "+this.toString());
    }

    @Override
    protected boolean checkConstructorArgs() {
        boolean result = true;
        if(width<1 || height<1)
            result = false;
        return result;
    }

    @Override
    public boolean commit(IDisplayable iDisplayable, Coordinate coordinate) {
        // lowerleft coordinate
        boolean result;
        Coordinate lowerRight = coordinate.offset(width-1, false).offset(height-1, true);
        result = iDisplayable.checkCoordinateValidity(coordinate) && iDisplayable.checkCoordinateValidity(lowerRight);
        log.debug("Display rectangle {} at: {} and {}", this, coordinate.toString(), lowerRight.toString());
        if (result){
            for (int i = 0;i<height;i++)
                iDisplayable.commit(coordinate.offset(i,true),'x');
            for (int i = 0;i<height;i++)
                iDisplayable.commit(coordinate.offset(width-1, false).offset(i, true),'x');
            for (int i = 0;i<width;i++)
                iDisplayable.commit(coordinate.offset(i,false),'x');
            for (int i = 0;i<width;i++)
                iDisplayable.commit(coordinate.offset(height-1, true).offset(i, false),'x');
        }
        return result;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
