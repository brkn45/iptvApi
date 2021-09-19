package com.iptv.iptv;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/link")
	public ResponseEntity<LinkSucces> linkTrust(@RequestBody LinkSucces linkSucces) throws IOException {
		String linkUrl = linkSucces.getLink();
		LinkSucces tmp;
		String filename = "berkan.m3u";
		File fileM3u = new File("berkan.m3u");
		
		//System.out.print("berkan");
		InputStream in = new URL(linkUrl).openStream();
		Files.copy(in, Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
		in.close();
		if(fileM3u.exists()) {
			tmp = new LinkSucces(linkUrl,true);
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		}
		else {
			tmp = new LinkSucces(linkUrl,true);
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		}
		
		
	}
	
}
