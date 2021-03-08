package org.oday.Messanger.db;

import java.util.HashMap;
import java.util.Map;

import org.oday.Messanger.model.Message;
import org.oday.Messanger.model.Profile;

public class DataBase {

		public    Map<Long,Message>messages=new HashMap<Long,Message>();
		public static Map<String ,Profile> profiles=new HashMap<String,Profile>();
		
		public DataBase() {
			System.out.println("Oday#1");
			for(int i=0;i<10;i++)
			messages.put((long) i, new Message((long)i,"Content Message "+i,"Oday "+i));
		}

		public Map<Long, Message> getMessages() {
			return messages;
		}

		public void setMessages(Map<Long, Message> messages) {
			this.messages = messages;
		}

		
		
}
