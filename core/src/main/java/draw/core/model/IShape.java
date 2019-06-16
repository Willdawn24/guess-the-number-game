package draw.core.model;

public interface IShape {
    boolean isOnBoundary(Coordinate coordinate);
    boolean isInside(Coordinate coordinate);
    default boolean isOutside(Coordinate coordinate){
        return !(isOnBoundary(coordinate) || isInside(coordinate));
    };
}
