package draw.core.model;


import draw.core.IDraw;

/**
 *
 */
public abstract class AbstractElementImpl implements IAbstractElement, ICommitable {

//    public AbstractElementImpl() throws IllegalArgumentException {
//        if(!checkConstructorArgs()){
//            throw new IllegalArgumentException("Invalid coordinates for create element "+this.getClass().getSimpleName());
//        }
//    }

    protected abstract boolean checkConstructorArgs();

    @Override
    public abstract boolean commit(IDisplayable displayable, Coordinate coordinate) throws IllegalArgumentException;
}
