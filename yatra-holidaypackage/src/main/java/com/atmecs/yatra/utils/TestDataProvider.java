package com.atmecs.yatra.utils;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;

import com.atmecs.yatra.constants.ConstantPaths;

public class TestDataProvider {

	Object[][] object;
	ExcelFileRead provider;

	public TestDataProvider() {
		provider = new ExcelFileRead(ConstantPaths.TESTDATA_FILE);

	}

	@DataProvider(name = "destination")
	public Object[][] provideData() {

		Iterator<Row> rows = null;
		try {
			rows = ExcelFileRead.getData();

			int noOfRows = provider.getNoOfRows();
			System.out.println(noOfRows);
			int noOfColumns = provider.getNoOfColumns();
			System.out.println(noOfColumns);
			object = new Object[noOfRows][noOfColumns];

		} catch (IOException e) {
			System.out.println("Exception");
		}
		int i = 0;
		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> iterator = row.cellIterator();
			int j = 0;
			while (iterator.hasNext()) {
				Cell cell = iterator.next();
				object[i][j] = cell.toString();
				j++;
			}
			i++;
		}
		return object;
	}
}