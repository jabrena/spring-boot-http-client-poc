package ms.info.ms.service;

import jakarta.annotation.PostConstruct;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class BeanInventory {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @PostConstruct
    public void after() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        AtomicInteger counter = new AtomicInteger(1);
        String SPACE = " ";

        Arrays.stream(allBeanNames)
                .map(beanName -> {
                    return new StringBuilder()
                            .append(counter.getAndIncrement())
                            .append(SPACE)
                            .append(beanName)
                            .toString();
                })
                .forEach(System.out::println);
    }

}
