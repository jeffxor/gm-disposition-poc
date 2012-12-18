package org.gm.dispositions;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class Producer 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/context/jms-context.xml", "META-INF/spring/context/producer-context.xml"});
    	MessageChannel inboundChannel = context.getBean("sendGMDispositionToJMS", MessageChannel.class);
    	
    	while(true){
    		Map<String, Object> headers = new HashMap<String, Object>();
    		Calendar instance = Calendar.getInstance();
    		headers.put("dateTime", instance.getTime());
    		headers.put("leadProvider", "GM");
    		
    		Message<Long> message = MessageBuilder.withPayload(instance.getTimeInMillis()).copyHeaders(headers).build();
    		System.out.println("Adding message with payload " + message.getPayload());
    		inboundChannel.send(message);
//    		Thread.sleep(2 * 1000);    	
    	}
        
    }
}
