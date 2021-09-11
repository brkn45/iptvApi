package com.iptv.iptv;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IpTvApi {
	
	@GetMapping("/alldata")
	public ResponseEntity<DataEntity> pushAllPassenger(){
		Parser parser = new Parser("berkan.m3u");
		parser.read();
		DataEntity data = new DataEntity(parser.getPictureLink(),parser.getGroupName(),parser.getChannelName(),parser.getLink());
		return new ResponseEntity<>(data, HttpStatus.OK);
		
	}
}
