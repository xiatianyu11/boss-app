package com.app.boss.message.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_chat")
public class Chat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@Column(name="from_user")
	private String from;
	
	@Column(name="to_user")
	private String to;
	
	@Column(name="`read`")
	private Boolean read;
	
	@Column(name="content")
	private String content;
	
	@Column(name="CREATE_TIME")
	private Date createTime;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
