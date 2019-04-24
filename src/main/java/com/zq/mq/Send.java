package com.zq.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.zq.utils.MqUtils;

public class Send {

    //队列名称  
    private final static String QUEUE_NAME = "queue";  

    public static void main(String[] argv) throws java.io.IOException  
    {  
        /**
         * 创建连接连接到MabbitMQ
         */
        Connection connection = MqUtils.getConnection();
        //创建一个频道
        Channel channel = MqUtils.getChannel(connection);
        //发送的消息  
        String message = "hello world!";  
        //往队列中发出一条消息
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("Sent '" + message + "'");  
        //关闭频道和连接  
        channel.close();  
        connection.close();  
     }  
}