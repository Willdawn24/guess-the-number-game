package draw.console;

import draw.core.IDraw;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

@Slf4j
@Component
public class ConsoleDraw {

    private final IDraw idraw;

    @Autowired
    public ConsoleDraw(IDraw idraw) {
        this.idraw = idraw;
    }

    //===== events ====
    @EventListener
    public void start(ContextRefreshedEvent event){
        log.info("Start draw program");
        System.out.println("Start draw program");
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit){
            System.out.println("please input your command");

            String command = scanner.nextLine();
            String[] commandArgs = command.split(" ");
            log.info(Arrays.toString(commandArgs));

            switch (commandArgs[0]){
                case "C":

                    System.out.println("Create canvus");
                    idraw.getDisplayable(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]));
                    idraw.display();
                    break;
                case "L":
                    System.out.println("create line ");
                    idraw.getLine(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]),
                            Integer.valueOf(commandArgs[3]), Integer.valueOf(commandArgs[4]));
                    idraw.display();
                    break;
                case "R":
                    System.out.println("create rectangle ");
                    idraw.getRectangle(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]),
                            Integer.valueOf(commandArgs[3]), Integer.valueOf(commandArgs[4]));
                    idraw.display();
                    break;
                case "Q":
                    quit = true;
                    break;
            }

//            scanner.nextLine();
//            game.setGuess(guess);
//            game.check();
//
//            if(game.isGameWon() || game.isGameLost()){
//                System.out.println(messageGenerator.getResultMessage());
//                System.out.println("Play it again? y/n");
//
//                String playAgainString = scanner.nextLine().trim();
//                if(!playAgainString.equalsIgnoreCase("y")){
//                    break;
//                }
//                game.reset();
//            }
        }
    }



}
