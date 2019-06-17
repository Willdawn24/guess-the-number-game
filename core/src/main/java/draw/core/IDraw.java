package draw.core;

public interface IDraw {
    void getCanvus(int width, int height);
    boolean getLine(int startX, int startY, int endX, int endY);
    void getRectangle(int startX, int startY, int endX, int endY) ;
    void display();
    void reset();
}
