package draw.core.model;

public abstract class ShapeImpl extends AbstractElementImpl implements IShape {

//    public ShapeImpl(Coordinate[] coordinates) throws IllegalArgumentException {
//        super(coordinates);
//    }

    @Override
    public boolean isOnBoundary(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean isInside(Coordinate coordinate) {
        return false;
    }

}
