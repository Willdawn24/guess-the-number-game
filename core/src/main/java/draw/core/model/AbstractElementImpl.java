package draw.core.model;


import draw.core.IDraw;

/**
 *
 */
public abstract class AbstractElementImpl implements IAbstractElement, ICommitable {

    protected abstract boolean checkConstructorArgs();

    @Override
    public abstract boolean commit(IDisplayable displayable, Coordinate coordinate) throws IllegalArgumentException;

}
