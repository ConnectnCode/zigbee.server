package org.cnc.zigbee.dao;

import java.util.List;

public interface PollDataDao {

	public List<String> fetchAll();
	public String fetchOne(Long time);
	
}
