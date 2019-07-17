package com.ParserJson.Parser;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;

import javax.swing.JOptionPane;

import com.ParserJson.ClassModel.Excel;
import com.ParserJson.ClassModel.ModelJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Launch {
	
	File file;
	
	public Launch(File file) {
		this.file = file;
	}
	
	
	public void start () throws IOException, ParseException {
		String url = file.getPath();
    	Path path = new File(url).toPath();
    	
    	Gson gson = new GsonBuilder().create();
    	
    	Reader reader = Files.newBufferedReader(path);
    	
    	ModelJson[] model = gson.fromJson(reader, ModelJson[].class);
    	    	
    	Excel excel = new Excel(model);
    	excel.create(path);
    	
    	JOptionPane.showMessageDialog(null, "Конвертация завершена");
    	
	}
}
