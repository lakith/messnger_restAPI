package org.arimac.jax.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arimac.jax.messenger.database.DatabaseClass;
import org.arimac.jax.messenger.model.Messagemodel;
import org.arimac.jax.messenger.model.Profile;





public class MessagesService {

	private static Map<Long,Messagemodel> messages = DatabaseClass.getMessages();
	
	public MessagesService(){
		Messagemodel m1 = new Messagemodel(1L,"This is sample 1","lakith");
		Messagemodel m2 = new Messagemodel(2L,"This is sample 2","lakith");
		messages.put(1L, m1);
		messages.put(2L, m2);
	}
	
	public Messagemodel getMessage(long id)
	{
		return messages.get(id);
	}
	public Messagemodel addMessage(Messagemodel message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Messagemodel updateMessage(Messagemodel message){
		
		if(message.getId() <= 0){
			return null;
		} else{
			messages.put(message.getId(), message);
			return message;
		}
		
	}
	
	public List<Messagemodel> getAllMessage()
	{
		return new ArrayList<Messagemodel>(messages.values()); 
	}
	public Messagemodel removeMessage(long id) {
		
		return messages.remove(id);
	}
	public List<Messagemodel> getAllmessagesForYear(int year){
		
		List<Messagemodel> messageForYEar = new ArrayList<Messagemodel>();
		Calendar cal = Calendar.getInstance();
		
		for(Messagemodel message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar .YEAR)==year){
				messageForYEar.add(message);
			}
		}
        return messageForYEar;
	}
	
	public List<Messagemodel> getAllMessagespaginated(int start , int size)
	{
		ArrayList<Messagemodel> list = new ArrayList<Messagemodel>(messages.values());
		if(start + size > list.size()) return new ArrayList<Messagemodel>();
		return list.subList(start, start+size);
		
	}
	
	
	
}
