package com.zq.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.zq.utils.MqUtils;

import java.io.IOException;

public class Recv  {
    //队列名称  
    private final static String QUEUE_NAME = "queue";  
    public static void main(String[] argv) throws java.io.IOException,
    java.lang.InterruptedException  
    {
        Channel channel = MqUtils.getChannel();
        System.out.println("Waiting for messages. To exit press CTRL+C");

        //创建队列消费者  
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //指定消费队列  
        channel.basicConsume(QUEUE_NAME, true, consumer);  
        while (true)  
        {  
            //nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）  
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();  
            String message = new String(delivery.getBody());  
            System.out.println("Received '" + message + "'");
        }  

    }
}