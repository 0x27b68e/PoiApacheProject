package com.quan.PoiDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
	
	        public static void main(String[] args) {
	        	try {
					FileOutputStream fileOutputStream = new FileOutputStream(new File("workBookFile2.xlsx"));
					
					Workbook workbook = new XSSFWorkbook();
					Sheet sheet = workbook.createSheet("data");
					
					XSSFRow createRow = (XSSFRow) sheet.createRow(1);
					createRow.createCell(0).setCellValue("Value 1");
					createRow.createCell(1).setCellValue("Value 2")	;
					
					createRow = (XSSFRow) sheet.createRow(2);
					createRow.createCell(0).setCellValue("Bank cell");
					createRow.createCell(1);
					
					createRow = (XSSFRow) sheet.createRow(3);
					createRow.createCell(0).setCellValue("Boolean cell");
					createRow.createCell(1).setCellValue(true);
					
					createRow = (XSSFRow) sheet.createRow(4);
					createRow.createCell(0).setCellValue("NUMber cell");
					createRow.createCell(1).setCellValue(32);
					
					createRow = (XSSFRow) sheet.createRow(5);
					createRow.createCell(0).setCellValue("String cell");
					createRow.createCell(1).setCellValue("Hello Hello Ho");
					
					createRow = (XSSFRow) sheet.createRow(6);
					createRow.createCell(0).setCellValue("Date cell");
					Date date = new Date();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					createRow.createCell(1).setCellValue(simpleDateFormat.format(date));
					
					
					
					workbook.write(fileOutputStream);
					workbook.close();
					fileOutputStream.close();
					
					System.out.println("ok");
					
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	//read va luu vao object
			public static void main5(String[] args) throws FileNotFoundException {
					FileInputStream fileInputStream = new FileInputStream(new File("workBookFile.xlsx"));
					ArrayList<NhanVien> arrayList = new ArrayList<NhanVien>();
					try {
						XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
						XSSFSheet sheet = xssfWorkbook.getSheet("data");
						Iterator<Row> iterator = sheet.iterator();
						
						while (iterator.hasNext()) {
							Row row = (Row) iterator.next();
							Iterator<Cell> cellIterator = row.cellIterator();
							NhanVien nhanVien =  new NhanVien();
							//
							while (cellIterator.hasNext()) {
								Cell cell = (Cell) cellIterator.next();
								
								switch (cell.getColumnIndex()) {
								case 1:
									nhanVien.setEmid(cell.getStringCellValue());
									break;
								case 2:
									nhanVien.setName(cell.getStringCellValue());
									break;
								case 3:
									nhanVien.setDesignation(cell.getStringCellValue());
									break;
								default:
									break;
								}
							}
							arrayList.add(nhanVien);
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (NhanVien nhanVien : arrayList) {
						System.out.println(nhanVien);
					}

				}
				
			

	//read va xuat on console
		public static void main4(String[] args) throws FileNotFoundException {
				FileInputStream fileInputStream = new FileInputStream(new File("workBookFile.xlsx"));
				TreeMap<String, Object[]> treeMap = new TreeMap<String, Object[]>();
				
				try {
					XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
					XSSFSheet sheet = xssfWorkbook.getSheet("data");
					Iterator<Row> iterator = sheet.iterator();
					
					while (iterator.hasNext()) {
						Row row = (Row) iterator.next();
						Iterator<Cell> cellIterator = row.cellIterator();
						while (cellIterator.hasNext()) {
							Cell cell = (Cell) cellIterator.next();
							switch (cell.getCellType()) {
							case STRING:
								System.out.print(cell.getStringCellValue() +" - ");
								break;
							case NUMERIC:
								System.out.print(cell.getNumericCellValue() + " - ");
								break;
							default:
								break;
							}
							
						}
						System.out.println();
						
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
	//write 
		@SuppressWarnings("resource")
		public static void main3(String[] args) throws FileNotFoundException {
			// TODO Auto-generated method stub
			
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
			XSSFSheet createSheet = xssfWorkbook.createSheet("data");
			XSSFRow createRow ;
			
			TreeMap<String, Object[]> treeMap = new TreeMap<String, Object[]>();
			treeMap.put("1", new Object[]{"EM ID", "EMP Name", "DESIGNATION"});
			treeMap.put("2", new Object[]{"Tp01", "Gopal", "Technical Manager"});
			treeMap.put("3", new Object[]{"TP02", "Manisha", "Proof Reader"});
			treeMap.put("4", new Object[]{"Tp03", "Masthan", "Technical Writer"});
			treeMap.put("5", new Object[]{"Tp04", "Satish", "Technical Writer"});
			
			Set<String> entrySet = treeMap.keySet();
			int rowIndex = 0;
			for (String string : entrySet) {
				createRow = createSheet.createRow(rowIndex++);
				Object[] objects = treeMap.get(string);
				
				int cellIndex = 0;
				for (Object string2 : objects) {
					XSSFCell createCell = createRow.createCell(cellIndex++);
					createCell.setCellValue((String)string2);
					
				}
					
			}
			
			FileOutputStream fileOutStream = new FileOutputStream(new File("workBookFile.xlsx"));
			try {
				xssfWorkbook.write(fileOutStream);
				xssfWorkbook.close();
				System.out.println("write to system ok");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}


	//read
	@SuppressWarnings("resource")
	public static void main2(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("testOutFile.xlsx");
		FileInputStream fileInputStream = null;
		XSSFWorkbook xssfWorkbook = null;
		try {
			if(!file.isFile()) {
				file.createNewFile();
			}
			fileInputStream = new FileInputStream(file);
			xssfWorkbook = new XSSFWorkbook(fileInputStream);
			System.out.println("ok");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//write 
	@SuppressWarnings("resource")
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File("workBookFile.xlsx"));
			xssfWorkbook.write(fileOutputStream);
			fileOutputStream.close();
			xssfWorkbook.close();
			System.out.println("ok");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
