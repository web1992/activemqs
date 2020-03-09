package cn.web1992.spring.boots.activemq.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.Destination;

@SpringBootTest
class ActivemqApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    void contextLoads() {
        Destination destination = new ActiveMQQueue("mytest.queue");

        for (int i = 0; i < 1; i++) {
            producer.sendMessage(destination, "myname is chhliu!!!");
        }
    }

}
