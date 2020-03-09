package cn.web1992.spring.boots.activemq.activemq;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * @author web1992
 * @date 2020/3/8  20:05
 */
@Component
public class AAListener implements MessageListener {

    @Override
    public void onMessage(Message message) {

        TextMessage msg = (TextMessage) message;
        try {
            System.out.println("msg is" + msg.getText());
//            throw new RuntimeException("asdasd");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
