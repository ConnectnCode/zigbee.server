package org.cnc.zigbee.controller;

import java.util.List;

public interface PollController {

	public static final String URL = "/v1/poll";
	
	public List<String> poll(Long time);
		
}
