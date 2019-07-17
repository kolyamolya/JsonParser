package com.ParserJson.ClassModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	String NAME = "\\Отчет.xlsx";
	ModelJson[] model;

	public Excel(ModelJson[] model) {
		this.model = model;
	}

	public void create(Path path) throws ParseException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Отчет");
				
		int countRow = 0;

		Row row = sheet.createRow(countRow);
		row.createCell(0).setCellValue("Email");
		row.createCell(1).setCellValue("ДЦ");
		row.createCell(2).setCellValue("ФИО");
		row.createCell(3).setCellValue("Должность");
		row.createCell(4).setCellValue("Дата");
		row.createCell(5).setCellValue("NEW S60");
		row.createCell(6).setCellValue("S90");
		row.createCell(7).setCellValue("V40CC");
		row.createCell(8).setCellValue("NEW V60CC");
		row.createCell(9).setCellValue("V90CC");
		row.createCell(10).setCellValue("XC40");
		row.createCell(11).setCellValue("XC60");
		row.createCell(12).setCellValue("XC90");
		row.createCell(13).setCellValue("Трафик за прошедшую неделю");
		
		countRow++;

		for (ModelJson md : model) {
			createSheetHeader(sheet, countRow++, md);
			System.out.println(md.getData().getS90());
		}

		FileOutputStream out = new FileOutputStream(new File(path.getParent() + NAME));
		workbook.write(out);
		workbook.close();
	}

	private void createSheetHeader(XSSFSheet sheet, int rowNum, ModelJson model) throws ParseException {
		Row row = sheet.createRow(rowNum);

		row.createCell(0).setCellValue(model.getEmail());
		row.createCell(4).setCellValue(converDate(model.getAt()));
		row.createCell(5).setCellValue(model.getData().getS60());
		row.createCell(6).setCellValue(model.getData().getS90());
		row.createCell(7).setCellValue(model.getData().getV40CC());
		row.createCell(8).setCellValue(model.getData().getV60cc());
		row.createCell(9).setCellValue(model.getData().getV90CC());
		row.createCell(10).setCellValue(model.getData().getXC40());
		row.createCell(11).setCellValue(model.getData().getXC60());
		row.createCell(12).setCellValue(model.getData().getXC90());
		row.createCell(13).setCellValue(model.getData().getTraffic_past_week());
	}

	private String converDate(long value) throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy HH:mm");
		Date date = Date.from(Instant.ofEpochSecond(value - 10800));
		return simpleDateFormat.format(date).toString();
	}

}
