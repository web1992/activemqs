package cn.web1992.spring.boots.activemq.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

@SpringBootTest
@ImportResource("classpath:*spring/spring.xml")
class ActivemqApplicationTests2 {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    void contextLoads() {
        Destination destination = new ActiveMQQueue("AAAA.queue");

        for (int i = 0; i < 1; i++) {
            jmsTemplate.send(destination, (session -> {
                return session.createTextMessage("asdasda");
            }));
        }
    }

}
