package draw.console;

public interface IDrawCommandPrompt {
    String getMainMessage();
    boolean command(String[] command);
}
