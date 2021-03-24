package com.amazonaws.samples;

import java.io.IOException;

public class VideoRecording {

	String videoName;
	private final static String URL = "http://206.207.50.7/getvideo";
	private final static String PATH = "/Users/vedavibalaji/eclipse-workspace/DetectObjects/videos";
	
	public static void RequestForVideo(){
		try {
			WebRequests.downloadFile(URL,PATH);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
