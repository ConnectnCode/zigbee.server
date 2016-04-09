package org.cnc.zigbee.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.cnc.zigbee.controller.PollController;
import org.cnc.zigbee.dao.PollDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollControllerImpl implements PollController {

	@Autowired
	private PollDataDao pollDataDao;
	
	@Override
	@RequestMapping(path = URL, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<String> poll(@RequestParam(name = "time", required = false) Long time) {

		if(time == null){
			return pollDataDao.fetchAll();
		}else{
			List<String> l = new ArrayList<String>();
			l.add(pollDataDao.fetchOne(time));
			return l;
		}
		

	}

}
