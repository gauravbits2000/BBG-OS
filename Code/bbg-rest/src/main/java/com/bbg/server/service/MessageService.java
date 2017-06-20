package com.bbg.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbg.model.Message;

public class MessageService 
{
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	
	public MessageService()
	{
		messages.put(1L, new Message(1L, "Hello Jersey",  "Gaurav"));
		messages.put(2L, new Message(2L, "Hello World",  "Gaurav"));
	}
	
	
	public List<Message> getMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(Long id){
		return messages.get(id);
	}
	
	
	public Message addMessage(Message message)
	{
		message.setId((long)messages.size() + 1 );
		messages.put(message.getId(), message);
		return message;
	}
	
	public void removeMessage(Long id){
		messages.remove(id);
	}
	
	public void updateMessage(Message message){
		messages.put(message.getId(), message);
	}
	
	public List<Message> getMessagesForYear(int year)
	{
		List<Message> messageList = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreatedOn());
			if(cal.get(Calendar.YEAR) == year){
				messageList.add(message);
			}
		}
		return messageList;
	}
	
	public List<Message> getMessagesForPagination(int start , int size)
	{
	 return new ArrayList<>(messages.values()).subList(start, start + size);
	}	
	
}
