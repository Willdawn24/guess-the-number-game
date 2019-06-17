package draw.core;

public interface IDraw {
    boolean getDisplayable(int width, int height);
    boolean getLine(int startX, int startY, int endX, int endY);
    boolean getRectangle(int startX, int startY, int endX, int endY) ;
    void display();
    void reset();
}
