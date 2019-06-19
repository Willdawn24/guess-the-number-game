package draw.console;

import draw.core.DrawImpl;
import draw.core.IDraw;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class DrawCommandPromptImplTest {
    private DrawCommandPromptImpl drawCommandPrompt;

    @Before
    public void before(){
        IDraw iDraw = new DrawImpl();
        drawCommandPrompt = new DrawCommandPromptImpl(iDraw);
    }

    @Test
    public void testGetMainMessage() {
        String string = "";
        assertNotEquals(string, drawCommandPrompt.getMainMessage());
    }

    @Test
    public void testCommandToCreateCanvus() {
        String[] commandArgs = {"C", "10", "2"};
        assertTrue(drawCommandPrompt.command(commandArgs));
    }

    @Test
    public void testCommandToCreateLine() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"L","1","1","2","1"};
        assertTrue(drawCommandPrompt.command(commandArgs2));
    }

    @Test
    public void testCommandToCreateRectangle() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"R","1","1","2","2"};
        assertTrue(drawCommandPrompt.command(commandArgs));
    }

    @Test
    public void testCommandToFill() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"R","1","1","3","3"};
        assertTrue(drawCommandPrompt.command(commandArgs2));
        String[] commandArgs3 = {"B","2","2","o"};
        assertTrue(drawCommandPrompt.command(commandArgs3));
    }

    @Test
    public void testCommandWithInvalidArgumentLength() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"R","1","1","3"};
        assertFalse(drawCommandPrompt.command(commandArgs2));
     }

}