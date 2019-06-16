package draw.core.config;

import draw.core.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "draw.core")
public class AppConfig {
//    @Bean
//    public NumberGenerator numberGenerator(){
//        return new NumberGeneratorImpl();
//    }

//    @Bean
//    public Game game(){
//        return new GameImpl();
//    }
//
//    @Bean
//    public MessageGenerator messageGenerator(){
//        return new MessageGeneratorImpl();
//    }

}
