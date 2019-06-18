package draw.console;

import draw.core.IDraw;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleDraw {

    private final IDraw idraw;
    private final IDrawCommandPrompt drawCommandPrompt;

    @Autowired
    public ConsoleDraw(IDraw idraw, IDrawCommandPrompt drawCommandPrompt) {
        this.idraw = idraw;
        this.drawCommandPrompt = drawCommandPrompt;
    }

    //===== events ====
    @EventListener
    public void start(ContextRefreshedEvent event){
        log.info("Start draw program");
        System.out.println("Please start your draw!");
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit){

            System.out.println(drawCommandPrompt.getMainMessage());

            String command = scanner.nextLine();
            String[] commandArgs = command.split(" ");

            if(commandArgs[0].equalsIgnoreCase("Q"))
                quit = true;
            else{
                if (drawCommandPrompt.command(commandArgs))
                    idraw.display();
                else{
                    log.info("Command not valid");
                    System.out.println("Command not valid");
                }

            }
        }
    }



}
