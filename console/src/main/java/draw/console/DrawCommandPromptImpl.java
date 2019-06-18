package draw.console;

import draw.core.IDraw;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
        return "Please input command:";
    }

    @Override
    public boolean command(String[] commandArgs) {
        log.debug(Arrays.toString(commandArgs));
        boolean result = false;
        try{
            switch (commandArgs[0].toUpperCase()) {
                case "C":
                    log.info("Create canvus");
                    result = iDraw.getDisplayable(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]));
                    break;
                case "L":
                    log.info("create line ");
                    result = iDraw.getLine(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]),
                            Integer.valueOf(commandArgs[3]), Integer.valueOf(commandArgs[4]));
                    break;
                case "R":
                    log.info("create rectangle ");
                    result = iDraw.getRectangle(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]),
                            Integer.valueOf(commandArgs[3]), Integer.valueOf(commandArgs[4]));
                    break;
                case "B":
                    log.info("fill color");
//                    if (commandArgs[3].charAt(0))
                    result = iDraw.fill(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]),commandArgs[3].charAt(0));
                    break;

                default:
                    break;
            }
        }catch (NumberFormatException e){
            log.error("Invalid command argument");
        }catch(ArrayIndexOutOfBoundsException exception){
            log.error("Invalid command arguments length");
        }
        return result;
    }

}
