package com.bjpowernode.aj.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * @author:whr 2019/10/30
 */
public class TestActiveMQP2P {

    /**
     * activemq的发送消息者
     */
    @Test
    public void send() {
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("failover:(tcp://192.168.64.139:61616,tcp://192.168.64.132:61616,tcp://192.168.64.133:61616)");
        try (Connection connection = activeMQConnectionFactory.createConnection();
             Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
             MessageProducer producer = session.createProducer(session.createQueue("testQ"))) {
            TextMessage textMessage = session.createTextMessage("测试text消息1");
            producer.send(textMessage);
            session.commit();
            System.out.println("发送成功");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * activemq的接收消息者
     */
    @Test
    public void consumer() {
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.139:61616");
        try (Connection connection = activeMQConnectionFactory.createConnection();
             Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
             MessageConsumer consumer = session.createConsumer(session.createQueue("testQ"))) {
            connection.start();
            Message receive = consumer.receive();
            if (receive instanceof TextMessage) {
                System.out.println(((TextMessage) receive).getText());
                session.commit();
                System.out.println("接收成功");
            } else {
                System.out.println("接收的消息不是TextMessage类型的，无法解析");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
