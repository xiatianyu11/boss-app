package com.app.boss.message.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.boss.message.entity.Chat;
import com.app.boss.message.repositories.ChatRepository;
import com.app.boss.message.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatRepository chatRepository;

	@Override
	public Chat saveChat(Chat chat) {
		chat.setCreateTime(new Date());
		return chatRepository.save(chat);
	}

	@Override
	public List<Chat> queryAllForFrom(String from) {
		return chatRepository.findAllByFrom(from);
	}

	@Override
	public List<Chat> queryAllForTo(String to) {
		return chatRepository.findAllByTo(to);
	}

	@Override
	public void readMsg(String from) {
		chatRepository.readMsg(true, from);
	}

}
