package com.zhenxl.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class UserConsumerMQ {
    public static void main(String[] args) throws JMSException {
        //1、创建Factory
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://192.168.223.132:61617"
        );

        //2、创建connect
        Connection connection = factory.createConnection();
        connection.start();
        //3、创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //获取Quene
        Queue queue = session.createQueue("userQueue");
        //4、创建consumer
        MessageConsumer consumer = session.createConsumer(queue);
        //消费消息
        while (true){
            TextMessage receive = (TextMessage) consumer.receive();
            System.out.println(receive.getText());
        }
    }
}
