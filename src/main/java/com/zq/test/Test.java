package com.zq.test;

import com.zq.mq.MessageInfo;
import com.zq.mq.Receiver;
import com.zq.mq.Sender;

public class Test {
    public static void main(String[] args) throws Exception{
        Receiver receiver = new Receiver("testQueue");
        Thread receiverThread = new Thread(receiver);
        receiverThread.start();
        Sender sender = new Sender("testQueue");
        for (int i = 0; i < 5; i++) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.setChannel("test");
            messageInfo.setContent("msg" + i);
            sender.sendMessage(messageInfo);
        }
    }
}