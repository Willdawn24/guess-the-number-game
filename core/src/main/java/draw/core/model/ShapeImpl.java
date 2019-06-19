package draw.core.model;

public abstract class ShapeImpl extends AbstractElementImpl implements IShape {
    @Override
    public boolean isOnBoundary(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean isInside(Coordinate coordinate) {
        return false;
    }

}
