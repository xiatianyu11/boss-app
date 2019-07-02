package com.app.boss.message.web;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.boss.message.entity.Chat;
import com.app.boss.message.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@PostMapping
	public ResponseEntity<Chat> saveChat(@RequestBody Chat chat) {
		return ResponseEntity.ok(chatService.saveChat(chat));
	}
	
	@GetMapping("/from/{from}")
	public ResponseEntity<List<Chat>> queryFromChat(@PathVariable String from) {
		return ResponseEntity.ok(chatService.queryAllForFrom(from));
	}
	
	@GetMapping("/to/{to}")
	public ResponseEntity<List<Chat>> queryToChat(@PathVariable String to) {
		return ResponseEntity.ok(chatService.queryAllForTo(to));
	}
	
	@PutMapping("/from/{from}")
	public ResponseEntity<Void> readMsg(@PathVariable String from) {
		chatService.readMsg(from);
		return ResponseEntity.ok().build();
	}

}
