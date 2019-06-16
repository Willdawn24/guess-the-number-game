package draw.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator {
//    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    private final Game game;

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    //==init==
    @PostConstruct
    public void init(){
        log.info("game={}", game);
    }
    @Override
    public String getMainMessage() {
        return "Number is between "+game.getSmallest()+" and "+game.getBiggest()+". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon())
            return "You guessed it! The number is "+game.getNumber();
        else if (game.isGameLost()){
            return "You lost. The number is "+game.getNumber();
        }else if(game.getRemainingGuesses() == game.getGuess()){
            return "what is your first guess?";
        }else {
            String direction="Lower!";
            if(game.getGuess()>game.getNumber()) {
                direction = "Higher";
            }
            return direction +"! You have "+game.getRemainingGuesses()+" guesses left";

        }
    }
}
