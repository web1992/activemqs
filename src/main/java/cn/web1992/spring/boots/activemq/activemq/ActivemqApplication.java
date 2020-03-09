package cn.web1992.spring.boots.activemq.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

@SpringBootApplication(exclude = {ActiveMQAutoConfiguration.class, JmsAutoConfiguration.class, JndiConnectionFactoryAutoConfiguration.class})
@ImportResource("classpath:*spring/spring.xml")
public class ActivemqApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ActivemqApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        Destination destination = new ActiveMQQueue("AAAA.queue");

        for (int i = 0; i < 1; i++) {
            jmsTemplate.send(destination, (session -> {
                return session.createTextMessage("asdasda");
            }));


        }
    }


}
