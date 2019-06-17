package draw.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

abstract class Command{
    private final IDraw iDraw;

    public Command(IDraw iDraw) {
        this.iDraw = iDraw;
    }

    abstract boolean command();
    abstract boolean checkCommandArgs(String[] args);
}



@Slf4j
@Component
public class DrawCommandPromptImpl implements IDrawCommandPrompt {
    private final IDraw iDraw;

    @Autowired
    public DrawCommandPromptImpl(IDraw iDraw) {
        this.iDraw = iDraw;
    }

    @Override
    public String getMainMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Please input command:");
        return sb.toString();
    }

    @Override
    public void getCommand(String[] command) {

    }

    @Override
    public void command(IDraw idraw) {

    }

    private boolean checkComandArgs(String[] args){
        return true;
    }
}
