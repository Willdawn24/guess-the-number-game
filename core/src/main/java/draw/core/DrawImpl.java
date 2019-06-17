package draw.core;

import draw.core.model.Canvus;
import draw.core.model.Coordinate;
import draw.core.model.Line;
import draw.core.model.Rectangle;

public class DrawImpl implements IDraw {
    Canvus canvus;
    @Override
    public void getCanvus(int width, int height) {
        canvus = new Canvus(width, height);
    }

    @Override
    public boolean getLine(int startX, int startY, int endX, int endY) throws IllegalArgumentException {
        Line line;
        boolean result = true;
        if (startX==endX && startY == endY){
            result = false;
        }else{
            if (startX == endX)
                line = new Line(endY-startY,true);
            else
                line = new Line(endX - startX, false);
            Coordinate drawPoint = new Coordinate(startX, startY);
            line.commit(canvus, drawPoint);
        }
        return result;
    }

    @Override
    public void getRectangle(int startX, int startY, int endX, int endY) throws IllegalArgumentException  {
        Rectangle rectangle;
        rectangle = new Rectangle(endX-startX, endY - endX);
        Coordinate drawPoint = new Coordinate(startX, startY);
        rectangle.commit(canvus, drawPoint);
    }


    @Override
    public void display() {
        canvus.show();
    }

    @Override
    public void reset() {
        canvus = null;
    }
}
