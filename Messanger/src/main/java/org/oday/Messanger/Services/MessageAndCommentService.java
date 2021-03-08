package org.oday.Messanger.Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oday.Messanger.Exception.DataNotFoundException;
import org.oday.Messanger.db.DataBase;
import org.oday.Messanger.model.Comment;
import org.oday.Messanger.model.Message;

public class MessageAndCommentService {

	private static MessageAndCommentService instance;
	DataBase db=new DataBase();
	private  Map<Long,Message>messages=db.getMessages();
	private MessageAndCommentService() {
		
		}		

	
	public static MessageAndCommentService getInestance() {
		System.out.println("Oday#2");
		if(instance==null) {
		instance=new MessageAndCommentService();
		
		}
		return instance;
		
	}
	
	public List<Message> getMessages(){
		
		return  new ArrayList<Message>(messages.values());
	}
	public Message getMessage(Long id) {
		
		Message m= messages.get(id);
		if(m==null)
			throw new DataNotFoundException("Message with this id = "+id+" not found");
		return m;
	}
	
	public List<Message> getAllMessageForYear(int year){
	List <Message> mess=new ArrayList<Message>();
	Calendar cal=Calendar.getInstance();
	for(Message m:messages.values()) {
		
		
		cal.setTime(m.getCreated());
		
		if(cal.get(Calendar.YEAR)==year)
			mess.add(m);
	}
	return mess;
	}
	
	public List<Message>getAllMessagePaginated(int start,int size){
		List<Message>list=new ArrayList<Message>(messages.values());
		if(start+size>list.size())
			return new ArrayList<Message>();
		return list.subList(start, start+size);
		
		
		
		
		
	}
	
	public Message addMessage(Message m) {
		m.setId((long) (messages.size()+1));
		
		messages.put(m.getId(), m);
		
		return m;
	}
	
	
	public Message updateMessage(Message m) {
		
		if(m.getId()<=0)
			return null;
		else {
			
		Message m2=	messages.getOrDefault(m.getId() ,null);
		if(m2==null)return null;
		else messages.put(m2.getId(), m);
	
		}
		
		
		return m;
	}
	
	public Message removeMessage(Long id) {
		
	Message m=	messages.remove(id);
	
	return m;
	
	
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Comment> getAllComments(long messageId){
		
		Message m=messages.get(messageId);
		if(m==null)
			return null;
		Map<Long,Comment> comments=m.getComments();
		if(comments.size()<=0)
			return null;
		
		
		return new ArrayList<Comment>(comments.values());
		
	}
	public Comment getComment(long mid,long cid) {
		
		
		return messages.get(mid).getComments().get(cid);
		
	}
	public Comment addComment(long mid,Comment c) {
		Map<Long ,Comment> comments=messages.get(mid).getComments();
			c.setId((long) (comments.size()+1));
			comments.put(c.getId(), c);
			messages.get(mid).setComments(comments);
			return c;	
	}
	
	public Comment updateComment(long mid,Comment c) {
		
		Map<Long ,Comment> comments=messages.get(mid).getComments();
		
		if(c.getId()<=0)
			return null;
		else {
			Comment c2=comments.getOrDefault(c.getId(), null);
			if(c2==null)
				return null;
			else {comments.put(c.getId(), c);
			messages.get(mid).setComments(comments);
			}
		}
		
		return c;

	}
	
	public Comment removeComment(long mid,long cid) {
		Map<Long ,Comment> comments=messages.get(mid).getComments();
		Comment c= comments.remove(cid);
		messages.get(mid).setComments(comments);
		return c;
	}
	
	
}
