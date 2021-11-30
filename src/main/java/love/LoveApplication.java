package love;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({
        @ComponentScan("config"),
        @ComponentScan("goods")
})
public class LoveApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoveApplication.class, args);
        System.out.println("新建的项目");
    }

}
