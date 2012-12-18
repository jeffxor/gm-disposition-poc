package org.gm.dispositions.integration;

import java.util.List;

import org.springframework.integration.Message;

public class SimpleAggregateMessageSplitter {

	@SuppressWarnings("unchecked")
	public List<Message<Long>> splitter(Message<Long> message){
		//Add Aggregate payload to split message headers
		List<Message<Long>> messages = (List<Message<Long>>) message.getHeaders().get("aggregatedMessages");		
//		for(Message<Long> splitMessage : messages){
//			splitMessage.getHeaders().put("aggregatePayload", message.getPayload());
//		}
		return messages;
	}
	
}
