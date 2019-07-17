package com.ParserJson.Parser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class DownloadSite {
	
	String urlStr = "https://stat.dmbasis.email:7777/report/question?campaign=";
	
	
	File file;

	public DownloadSite(File file) {
		this.file = file;
	}

	public void statrDownload() throws IOException {
		
	}

	private void downloadUsingStream(URL urlStr, File file) throws IOException {
	   
		
		
	}
}
