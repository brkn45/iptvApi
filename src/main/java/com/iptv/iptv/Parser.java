package com.iptv.iptv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;

import org.yaml.snakeyaml.util.ArrayUtils;

public class Parser {
	private ArrayList<String> line;
    private ArrayList<String> pictureLink;
    private ArrayList<String> groupName;
    private ArrayList<String> channelName;
    private ArrayList<String> link;
    private String firsLine;
  
    File file;
    public Parser (String filename){
        file = new File(filename);
        this.pictureLink =new ArrayList<String>();
        this.groupName   =new ArrayList<String>();
        this.channelName =new ArrayList<String>();
        this.link        =new ArrayList<String>();
        this.line        =new ArrayList<String>();
    }
    public  void read() {



        try {
           
            Scanner myReader = new Scanner(file);
            myReader.hasNextLine();
            firsLine = myReader.nextLine();
           

            while (myReader.hasNextLine()) {
                line.add(myReader.nextLine());
                //System.out.println(line.get(i));

            }
            //System.out.println("i: " +i);
            parser();
            myReader.close();
           //file.delete();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void parser() {
        int i=1;

        String[] tmp = new String[100];
        for(i=0;i<line.size();i++) {
        	
            if(line.get(i).indexOf("#EXTINF:-1") >-1) {
                tmp = line.get(i).split("\"");
                //System.out.println("tvg-name:" +tmp[3]);
                if(tmp[3].length() >0) {
                	channelName.add(tmp[3]);
                }
                
                //System.out.println("tvg-logo:" +tmp[5]);
                /*if(tmp[5].length() >0) {
                	pictureLink.add(tmp[5]);
                }*/
                
                
                //System.out.println("group-title:"+tmp[7]);
                if(tmp[7].length() >0) {
                	groupName.add(tmp[7]);
                }
                i++;
                link.add(line.get(i));
            }
            
        }
        //System.out.println("line Number:" + line.size());
    }
    public boolean deleteFile() {
    	return file.delete();
    }

    public ArrayList<String> getChannelName() {
        return channelName;
    }

    public ArrayList<String> getGroupName() {
        return groupName;
    }

    public ArrayList<String> getLine() {
        return line;
    }

    public ArrayList<String> getLink() {
        return link;
    }

    public ArrayList<String> getPictureLink() {
        return pictureLink;
    }

    public String getFirsLine() {
        return firsLine;
    }

}
