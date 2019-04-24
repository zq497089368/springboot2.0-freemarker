package com.zq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class MqUtils {
    public final static String QUEUE_NAME = "queue";

    public static Connection getConnection() throws IOException{
        //打开连接和创建频道，与发送端一样
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在主机ip或者主机名
        factory.setHost("148.70.163.33");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        return connection;
    }

    public static Channel getChannel(Connection connection) throws IOException{
        Channel channel = connection.createChannel();
        //声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        return channel;
    }

    public static Channel getChannel() throws IOException{
        return getChannel(getConnection());
    }
}
