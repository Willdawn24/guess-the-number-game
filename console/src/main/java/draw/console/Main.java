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
        log.info("Start draw program!");
        SpringApplication.run(Main.class, args);

    }
}
