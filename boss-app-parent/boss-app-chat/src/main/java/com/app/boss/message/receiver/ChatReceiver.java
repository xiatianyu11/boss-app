package com.app.boss.message.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.app.boss.message.entity.Chat;
import com.app.boss.message.service.ChatService;

@Component
@RabbitListener(queues = "chat")
public class ChatReceiver {
	@Autowired
	private ChatService chatService;
	
	@RabbitHandler
    public void process(String message) {
        JSONObject jsonObject = JSON.parseObject(message);
		String textMessage = jsonObject.getString("message");
		String fromusername = jsonObject.getString("from");
        String tousername = jsonObject.getString("to");
        Chat chat = new Chat();
		chat.setFrom(fromusername);
		chat.setTo(tousername);
		chat.setContent(textMessage);
		chat.setRead(false);
		chatService.saveChat(chat);
    }

}
