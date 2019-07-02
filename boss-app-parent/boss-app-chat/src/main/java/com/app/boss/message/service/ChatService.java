package com.app.boss.message.service;

import java.util.List;

import com.app.boss.message.entity.Chat;

public interface ChatService {
	
	Chat saveChat(Chat chat);
	
	List<Chat> queryAllForFrom(String from);
	
	List<Chat> queryAllForTo(String to);
	
	void readMsg(String from);

}
