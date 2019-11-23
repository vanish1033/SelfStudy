package com.bjpowernode.aj.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * @author:whr 2019/10/31
 */
public class yibuActiveMQ {

    @Test
    public void send() {
        try {
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.139:61616");
            Connection connection = activeMQConnectionFactory.createConnection();
            Session session = connection.createSession(Boolean.TRUE, Session.SESSION_TRANSACTED);

            MessageProducer yibu = session.createProducer(session.createQueue("yibu"));
            for (int i = 0; ; i++) {
                yibu.send(session.createTextMessage(i + ""));
                session.commit();
                System.out.println("消息" + i + "发送成功");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void consumer1() throws JMSException, InterruptedException {
        MessageConsumer yibu = null;
        try {
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.139:61616");
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            yibu = session.createConsumer(session.createQueue("yibu"));
        } catch (JMSException e) {
            e.printStackTrace();
        }
        yibu.setMessageListener(message -> {
            try {
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(textMessage.getText());
                    message.acknowledge();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void consuner2() {
        MessageConsumer yibu = null;
        try {
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.139:61616");
            Connection connection = activeMQConnectionFactory.createConnection();
            Session session = connection.createSession(Boolean.TRUE, Session.SESSION_TRANSACTED);
            yibu = session.createConsumer(session.createQueue("yibu"));
            MessageConsumer finalYibu = yibu;
            connection.start();
            Thread thread = new Thread(() -> {
                try {
                    for (int i = 0; ; i++) {
                        Message receive = finalYibu.receive();
                        if (receive instanceof TextMessage) {
                            TextMessage message = (TextMessage) receive;
                            System.out.println(message.getText());
                            session.commit();
                        }
                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            thread.join();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
