package draw.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"draw.core","draw.console"})
public class Main {
//    private static final Logger log = LoggerFactory.getLogger(Main.class);
//    private static final String CONFIG_LOCATION="beans.xml";
    public static void main(String[] args){
        log.info("guess the number game!");

        SpringApplication.run(Main.class, args);
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
//        ConfigurableApplicationContext context =
//                new AnnotationConfigApplicationContext(GameConfig.class);
////        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
////
////        int num = numberGenerator.next();
////
////        log.info("number = {}",num);
////
////        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
////        log.info("getMainMessage={}", messageGenerator.getResultMessage());
////        log.info("getResultMessage={}", messageGenerator.getResultMessage());
////        Game game = context.getBean(Game.class);
////        game.reset();
//
//        context.close();
    }
}
