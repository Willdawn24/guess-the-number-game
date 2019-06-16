package draw.core.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Canvus implements IDisplayable,IShape {
    private Coordinate lowerLeft, uppderRight;
    private int width, height;
    private Point[][] points;

    public Canvus(int width, int height) throws IllegalArgumentException{
        if (width>0 && height >0){
            lowerLeft = new Coordinate(0,0);
            uppderRight = new Coordinate(width, height);
            this.width = width;
            this.height = height;
            points = new Point[width][height];
            commit(this, null);

        }else{
            throw new IllegalArgumentException("Invalid arguments for Canvus");
        }
    }

    public Point getPoint(Coordinate coordinate) throws RuntimeException{
        Point result = null;
        if (!isOutside(coordinate))
            result = points[coordinate.getxCoordinate()][coordinate.getyCoordinate()];
        else
            throw new RuntimeException("Invalid Coordinate");
        return result;
    }

    public void show() {
        for(int i =0; i<width;i++){
            for(int j = 0;j<height;j++){
                System.out.print(points[i][j].getCharacter());
            }
            System.out.println("");
        }
    }

    public boolean checkCordinateValidity(Coordinate coordinate){
        return isOnBoundary(coordinate) || isInside(coordinate);
    }

//    public boolean checkValidity(Coordinate[] coordinates){
//        boolean result = true;
//        for(Coordinate coordinate: coordinates){
//            if(!checkValidity( coordinate)){
//                result = false;
//                break;
//            }
//        }
//        return result;
//    }

    public boolean commit(Point point, Coordinate coordinate){
        boolean result = true;
        try{
            getPoint(coordinate).setCharacter(point.getCharacter());
        }catch(Exception exception){
            result = false;
        }
        return result;
    }

    @Override
    public boolean commit(Canvus canvus, Coordinate coordinate) {
        for (int i = 0;i<height;i++)
            getPoint(new Coordinate(0,i)).setCharacter('|');
        for (int i = 0;i<height;i++)
            getPoint(new Coordinate(width, i)).setCharacter('|');
        for (int i = 0;i<width;i++)
            getPoint(new Coordinate(i,0)).setCharacter('-');
        for (int i = 0;i<width;i++)
            getPoint(new Coordinate(i,height)).setCharacter('-');
        return true;
    }

    @Override
    public boolean isOnBoundary(Coordinate cdnt) {
        return isOnHorizontalBoundary(cdnt) || isOnVerticalBoundary(cdnt);
    }

    @Override
    public boolean isInside(Coordinate coordinate) {
        boolean result = true;
        if ( coordinate.getxCoordinate() <=lowerLeft.getxCoordinate() || coordinate.getxCoordinate()>=uppderRight.getxCoordinate())
            result = false;
        if (coordinate.getyCoordinate()<=lowerLeft.getyCoordinate()|| coordinate.getyCoordinate()>=uppderRight.getyCoordinate())
            result = false;

        return result;
    }

    public boolean isOnVerticalBoundary(Coordinate cdnt){
        boolean result = true;
        if (cdnt.getxCoordinate() != lowerLeft.getxCoordinate() && cdnt.getxCoordinate() != uppderRight.getxCoordinate())
            result = false;
        if (cdnt.getyCoordinate() < lowerLeft.getyCoordinate() || cdnt.getyCoordinate() > uppderRight.getyCoordinate())
            result = false;
        return result;
    }

    public boolean isOnHorizontalBoundary(Coordinate cdnt){
        boolean result = true;
        if (cdnt.getyCoordinate() != lowerLeft.getyCoordinate() && cdnt.getyCoordinate() != uppderRight.getyCoordinate())
            result = false;
        if (cdnt.getxCoordinate() < lowerLeft.getxCoordinate() || cdnt.getxCoordinate() > uppderRight.getxCoordinate())
            result = false;
        return result;
    }



}
