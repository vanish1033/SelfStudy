package com.bjpowernode.aj.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * @author:whr 2019/10/30
 */
public class TestActiveMQtopic {

    @Test
    public void send() {
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.139:61616");
        try (Connection connection = activeMQConnectionFactory.createConnection();
             Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
             MessageProducer producer = session.createProducer(session.createTopic("topic"))) {

            TextMessage message = session.createTextMessage("测试topic消息");
            producer.send(message);
            System.out.println("测试topic成功");
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void consumer() {

        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.139:61616");

        try (Connection connection = activeMQConnectionFactory.createConnection();
             Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
             MessageConsumer consumer = session.createConsumer(session.createTopic("topic"))) {

            connection.start();
            Message receive = consumer.receive();

            if (receive instanceof TextMessage) {
                System.out.println(((TextMessage) receive).getText());
            } else {
                System.out.println("message不属于TextMessage类型，无法解析");
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
