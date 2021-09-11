package com.iptv.iptv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IptvApplication {

	

	public static void main(String[] args) throws IOException {
		SpringApplication.run(IptvApplication.class, args);
		File file = new File("http://redson.xyz:6464/get.php?username=turgutluhlkegt&password=K56DwQmRLU&type=m3u_plus&output=mpegts");
		URL website = new URL("http://redson.xyz:6464/get.php?username=turgutluhlkegt&password=K56DwQmRLU&type=m3u_plus&output=mpegts");
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream("berkan.m3u");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		//System.out.print("berkan");
		
	}

}
