package org.gm.dispositions.integration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

public class SimpleMessagePayloadAggregator {

	public Message<Long> aggregate(List<Message<Long>> messages){
		Map<String, Object> headersToCopy = new HashMap<String, Object>();
		headersToCopy.put("leadProvider", messages.get(0).getHeaders().get("leadProvider"));
		headersToCopy.put("aggregatedMessages", messages);
		
		Long aggregate = 0L;
		for(Message<Long> message : messages){
			aggregate =+ message.getPayload();
		}
		
		return MessageBuilder.withPayload(aggregate).copyHeaders(headersToCopy).build();
	}
}
