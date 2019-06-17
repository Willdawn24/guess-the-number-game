package draw.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "draw.core")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    //-----fields------
    @Value("${game.maxNumber:100}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:10}")
    private int minNumber;

    //-----bean methods
    @Bean
    public int maxNumber1(){
        return maxNumber;
    }

    @Bean
    public int guessCount1(){
        return  guessCount;
    }

    @Bean
    public int minNumber(){
        return minNumber;
    }
}
