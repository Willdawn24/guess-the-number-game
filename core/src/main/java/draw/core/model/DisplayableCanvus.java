package draw.core.model;

import draw.core.IDraw;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class DisplayableCanvus implements IShape, IDisplayable {
    private Coordinate upperLeft, lowerRight;
    private int width, height;
    private Point[][] points;

    public DisplayableCanvus(int width, int height) throws IllegalArgumentException{
        if (width>0 && height >0){
            this.width = width+2;
            this.height = height+2;
            upperLeft = new Coordinate(0,0);
            lowerRight = new Coordinate(width+1, height+1);

            points = new Point[this.height][this.width];
            initiatePoints();
            commit();
            log.info("Create canvus:{}", this);
        }else{
            throw new IllegalArgumentException("Invalid arguments for DisplayableCanvus");
        }
    }

    // -------------public methods----------
    @Override
    public boolean commit(Coordinate coordinate, char c) {
        boolean result = true;
        try{
            getPoint(coordinate).setCharacter(c);
        }catch(IndexOutOfBoundsException exception){
            log.error("Commit failed to retrieve point {}", coordinate);
            result = false;
        }
        return result;
    }

    public char getChar(Coordinate coordinate) {
        return points[coordinate.getyCoordinate()][coordinate.getxCoordinate()].getCharacter();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void display() {
        for(int i =0; i< height;i++){
            for(int j = 0;j<width;j++){
                System.out.print(points[i][j].getCharacter());
            }
            System.out.println("");
        }
    }

    public boolean checkCoordinateValidity(Coordinate coordinate){
        return isInside(coordinate);
    }

    @Override
    public boolean isOnBoundary(Coordinate cdnt) {
        return isOnHorizontalBoundary(cdnt) || isOnVerticalBoundary(cdnt);
    }

    @Override
    public boolean isInside(Coordinate coordinate) {
        boolean result = true;
        if ( coordinate.getxCoordinate() <=upperLeft.getxCoordinate() || coordinate.getxCoordinate()>=lowerRight.getxCoordinate())
            result = false;
        if (coordinate.getyCoordinate()<=upperLeft.getyCoordinate()|| coordinate.getyCoordinate()>=lowerRight.getyCoordinate())
            result = false;

        return result;
    }

    public boolean isOnVerticalBoundary(Coordinate cdnt){
        boolean result = true;
        if (cdnt.getxCoordinate() != upperLeft.getxCoordinate() && cdnt.getxCoordinate() != lowerRight.getxCoordinate())
            result = false;
        if (cdnt.getyCoordinate() < upperLeft.getyCoordinate() || cdnt.getyCoordinate() > lowerRight.getyCoordinate())
            result = false;
        return result;
    }

    public boolean isOnHorizontalBoundary(Coordinate cdnt){
        boolean result = true;
        if (cdnt.getyCoordinate() != upperLeft.getyCoordinate() && cdnt.getyCoordinate() != lowerRight.getyCoordinate())
            result = false;
        if (cdnt.getxCoordinate() < upperLeft.getxCoordinate() || cdnt.getxCoordinate() > lowerRight.getxCoordinate())
            result = false;
        return result;
    }


    public void fill(Coordinate coordinate, char character) throws IndexOutOfBoundsException{
        Set<Coordinate> set = new HashSet<Coordinate>();
        fillHelper(set, coordinate,character);
    }

    @Override
    public String toString() {
        return "DisplayableCanvus{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    // -------------private methods----------
    private Point getPoint(Coordinate coordinate) throws IndexOutOfBoundsException{
        Point result = null;
        if (!isOutside(coordinate))
            result = points[coordinate.getyCoordinate()][coordinate.getxCoordinate()];
        else
            throw new IndexOutOfBoundsException("Invalid Coordinate");
        return result;
    }

    private boolean commit() {
        int i;
        for (i = 0; i < height; i++)
            getPoint(new Coordinate(0, i)).setCharacter('|');
        for (i = 0; i < height; i++)
            getPoint(new Coordinate(width-1, i)).setCharacter('|');
        for (i = 0; i < width; i++)
            getPoint(new Coordinate(i, 0)).setCharacter('-');
        for (i = 0; i < width; i++)
            getPoint(new Coordinate(i, height-1)).setCharacter('-');

        return true;
    }

    private void initiatePoints(){
        for (int i = 0;i<height;i++){
            for(int j= 0;j<width;j++){
                points[i][j] = new Point();
            }
        }
    }


    private void fillHelper(Set<Coordinate> set, Coordinate coordinate, char c){
        set.add(coordinate);
        if(isInside(coordinate)){
            if(checkFill(getPoint(coordinate))){
                getPoint(coordinate).setCharacter(c);
                Coordinate left = coordinate.offset(-1, false);
                Coordinate right = coordinate.offset(1, false);
                Coordinate up= coordinate.offset(-1, true);
                Coordinate down= coordinate.offset(1, true);

                if (!set.contains(left)){
                    fillHelper(set, left, c);
                }
                if(!set.contains(right)){
                    fillHelper(set, up, c);
                }
                if (!set.contains(right)){
                    fillHelper(set, right, c);
                }
                if(!set.contains(down)){
                    fillHelper(set, down, c);
                }
            }
        }
    }

    private boolean checkFill(Point point){
        char currentChar = point.getCharacter();
        return currentChar!='-'&& currentChar!='|'&&currentChar!='x';
    }

}
