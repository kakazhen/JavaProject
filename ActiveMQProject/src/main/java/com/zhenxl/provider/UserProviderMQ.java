package com.zhenxl.provider;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class UserProviderMQ {
    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://192.168.223.132:61617"
        );
        //从工厂中获取一个连接
        Connection con = factory.createConnection();
        con.start();
        //从连接中获取session
       Session session= con.createSession(false, Session.AUTO_ACKNOWLEDGE);
       //从会话中获取queue
       Queue queue = session.createQueue("userQueue");
       //从会话中获取provider
        MessageProducer producer = session.createProducer(queue);
        //从会话中创建文本信息
        for (int i = 0; i < 100; i++) {
            TextMessage textMessage = session.createTextMessage("msg:" + i);
            Thread.sleep(1000);
            producer.send(textMessage);
        }
        //关闭连接
        con.close();
        System.out.println("provider exit");
    }
}
