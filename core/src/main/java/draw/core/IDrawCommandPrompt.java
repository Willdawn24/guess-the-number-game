package draw.core;

public interface IDrawCommandPrompt {
    String getMainMessage();
    void getCommand(String[] command);
    void command(IDraw idraw);
}
