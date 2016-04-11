package org.cnc.zigbee.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.cnc.zigbee.dao.PollDataDao;
import org.springframework.stereotype.Service;

@Service
public class PollDataFileDaoImpl implements PollDataDao {

	static final String pathTo = "./temp_data";

	private void fileExists()
	{
		if( Files.exists(Paths.get(pathTo), LinkOption.NOFOLLOW_LINKS)){
			return;
		}
		try {
			Files.createFile(Paths.get(pathTo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> fetchAll() {
		fileExists();
		try {
			return Files.readAllLines(Paths.get(pathTo)).stream()
			.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

//	@Override
//	public String fetchOne(Long time) {
//
//		Optional<String> findFirst = null;
//
//		fileExists();
//		try {
//			findFirst = Files.readAllLines(Paths.get(pathTo)).stream().map((l) -> l.split("#"))
//					.filter((l) -> l[0].equals(time.toString())).map((s) -> s[1]).findFirst();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return (findFirst == null) ? "" : findFirst.get();
//	}

}
