package com.bjpowernode.aj.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * @author:whr 2019/10/31
 */
public class TransactionActivcemq {

    @Test
    public void send() {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.139:61616");
        try (Connection connection = activeMQConnectionFactory.createConnection();
             Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
             MessageProducer producer = session.createProducer(session.createQueue("Transaction"));
        ) {
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage transaction1 = session.createTextMessage("Transaction消息1");
            transaction1.setIntProperty("age", 1);
            producer.send(transaction1);
//            System.out.println(1/0);
            TextMessage transaction2 = session.createTextMessage("Transaction消息2");
            transaction2.setIntProperty("age", 2);
            producer.send(transaction2);
            System.out.println("发送成功");
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void consumer() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.139:61616");

        try (Connection connection = activeMQConnectionFactory.createConnection();
             Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
             MessageConsumer consumer = session.createConsumer(session.createQueue("Transaction"), "age = 1")) {

            connection.start();

            Message receive = consumer.receive();
            if (receive instanceof TextMessage) {
                System.out.println("((TextMessage) receive).getText() = " + ((TextMessage) receive).getText());
//                session.commit();
                receive.acknowledge();
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }


}
