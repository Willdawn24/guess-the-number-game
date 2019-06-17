package draw.core.model;

import draw.core.IDraw;

public interface ICommitable {
    boolean commit(IDisplayable displayable, Coordinate coordinate);
}
