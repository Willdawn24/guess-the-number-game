package draw.core;

import draw.core.model.DisplayableCanvus;
import draw.core.model.Coordinate;
import draw.core.model.Line;
import draw.core.model.Rectangle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DrawImpl implements IDraw {
    DisplayableCanvus displayableCanvus;
    @Override
    public boolean getDisplayable(int width, int height) {
        boolean result = true;
        try{
            displayableCanvus = new DisplayableCanvus(width, height);
        }catch (IllegalArgumentException e){
            log.error("Failed to create canvus with width {} and height {}. {}", width, height, e.getMessage());
        }
        return result;
    }

    @Override
    public boolean getLine(int startX, int startY, int endX, int endY) {
        Line line;
        boolean result = true;
        try{
            if (startX == endX)
                line = new Line(1+Math.abs(endY-startY),true);
            else if(startY == endY)
                line = new Line(1+Math.abs(endX - startX), false);
            else
                throw new IllegalArgumentException("Neither the argument is vertical, nor is horizontal.");
            Coordinate drawPoint = new Coordinate(startX, startY);
            if(!line.commit(displayableCanvus, drawPoint))
                result = false;
        }catch(IllegalArgumentException e){
            result = false;
            log.error("Failed to create line from {},{} to {},{}. {}", startX, startY, endX, endY, e.getMessage());
        }
        return result;
    }

    @Override
    public boolean getRectangle(int startX, int startY, int endX, int endY)  {
        Rectangle rectangle;
        boolean result = true;
        try{
            rectangle = new Rectangle(1+Math.abs(endX-startX), 1+Math.abs(endY - startY));
            Coordinate drawPoint = new Coordinate(startX, startY);
            rectangle.commit(displayableCanvus, drawPoint);
        }catch(IllegalArgumentException e){
            result = false;
            log.error("Failed to create rectangle at {} and {}. {}", new Coordinate(startX, startY), new Coordinate(endX, endY), e.getMessage());
        }
        return result;
    }

    @Override
    public boolean fill(int x, int y, char c) {
        boolean result = true;
        Coordinate coordinate = new Coordinate(x, y);
        try{
            if(c == 'x' || c=='-' || c=='|')
                result = false;
            else
                displayableCanvus.fill(coordinate, c);
        }catch (IndexOutOfBoundsException exception){
            log.error("Failed to fill {} at {}", c, coordinate);
            result = false;
        }
        return result;
    }

    @Override
    public void display() {
        displayableCanvus.display();
    }

    @Override
    public void reset() {
        displayableCanvus = null;
    }
}
