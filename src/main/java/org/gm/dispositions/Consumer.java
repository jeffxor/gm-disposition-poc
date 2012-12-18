package org.gm.dispositions;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.channel.QueueChannel;

/**
 * Hello world!
 *
 */
public class Consumer 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/context/jms-context.xml", "META-INF/spring/context/consumer-context.xml"});
//    	QueueChannel outboundChannel = context.getBean("processedGMDisposition", QueueChannel.class);
    	
//    	while(true){
//    		Message<?> receive = outboundChannel.receive(2 * 1000);
//    		if(receive != null){
//	    		Date sentDate = (Date) receive.getHeaders().get("dateTime");
//	    		System.out.println("Recieved Message with payload " + receive.getPayload() + " with dateTime " + sentDate);
//    		}
//    	}

    }
}
