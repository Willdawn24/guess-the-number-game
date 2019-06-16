package draw.core.model;


import java.util.Collection;

/**
 *
 */
public abstract class AbstractElementImpl implements IAbstractElement,  IDisplayable{

//    public AbstractElementImpl() throws IllegalArgumentException {
//        if(!checkConstructorArgs()){
//            throw new IllegalArgumentException("Invalid coordinates for create element "+this.getClass().getSimpleName());
//        }
//    }

    protected abstract boolean checkConstructorArgs();

    @Override
    public abstract boolean commit(Canvus canvus, Coordinate coordinate) throws IllegalArgumentException;
}
