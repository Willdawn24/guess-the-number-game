package draw.core.model;

public interface IDisplayable {
    void display();
    boolean checkCordinateValidity(Coordinate coordinate);
    Point getPoint(Coordinate coordinate);
}
