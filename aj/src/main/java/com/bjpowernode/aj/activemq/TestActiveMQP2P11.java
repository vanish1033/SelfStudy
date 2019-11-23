package com.bjpowernode.aj.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 * @author:whr 2019/10/30
 */
public class TestActiveMQP2P11 {

    @Test
    public void send() {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.139:61616");
        try (Connection connection = activeMQConnectionFactory.createConnection();
             Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
             MessageProducer testQ = session.createProducer(session.createQueue("testQ"))
        ) {
            testQ.send(session.createTextMessage("123"));
        } catch (JMSException e) {
            e.printStackTrace();
        }
        System.out.println("发送成功");
    }

}
