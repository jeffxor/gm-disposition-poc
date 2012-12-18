package org.gm.dispositions.integration;

public class SimpleGMDispositionService {

	public String gmDispositionService(Long timestamp) throws Exception{
		if(timestamp % 5 == 0){
			throw new Exception("timestamp divisiable by 5");
		}
		return "Message Processed";
	}
}
