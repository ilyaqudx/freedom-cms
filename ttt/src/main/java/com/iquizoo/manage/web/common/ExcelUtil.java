package com.iquizoo.manage.web.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.iquizoo.manage.web.export.Column;
import com.iquizoo.manage.web.export.ColumnData;

/** Excel 工具 */
public class ExcelUtil {

	/**
	 * 读取office 2003 xls
	 * 
	 * @param filePath
	 */
	public void loadXls(String filePath) {
		try {
			InputStream input = new FileInputStream("D://test.xls");
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			// Iterate over each row in the sheet
			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				System.out.println("Row #" + row.getRowNum());
				// Iterate over each cell in the row and print out the cell"s
				// content
				Iterator cells = row.cellIterator();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					System.out.println("Cell #" + cell.getCellNum());
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC:
						System.out.println(cell.getNumericCellValue());
						break;
					case HSSFCell.CELL_TYPE_STRING:
						System.out.println(cell.getStringCellValue());
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						System.out.println(cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_FORMULA:
						System.out.println(cell.getCellFormula());
						break;
					default:
						System.out.println("unsuported sell type");
						break;
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 读取office 2007 xlsx
	 * 
	 * @param filePath
	 */
	public static List<List<String>> readXlsx(MultipartFile file,int startRow) {
		
		List<List<String>> returnList = null;
		XSSFWorkbook xwb = null;
		try {
			returnList = new ArrayList<List<String>>();
			InputStream is = file.getInputStream();
			xwb = new XSSFWorkbook(is);
			// 读取第一章表格内容
			XSSFSheet sheet = xwb.getSheetAt(0);
			// 定义 row、cell
			XSSFRow row;
			String cell;

			XSSFRow tmpRow = sheet.getRow(0); // 从第一行去列的长度
			int columNum = 0;
			for (int j = 0; j < tmpRow.getPhysicalNumberOfCells(); j++) {
				if (tmpRow.getCell(j) != null
						&& !tmpRow.getCell(j).toString().equals("")
						&& !tmpRow.getCell(j).toString().equals(" ")) {
					columNum++;
				}
			}

			// 循环输出表格中的内容
			for (int i = startRow; i < sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				List<String> rowValues = new ArrayList<String>();
				for (int j = 0; j < columNum; j++) {
					XSSFCell cell1 = row.getCell(j);
					if (row.getCell(j) != null) {
						switch (cell1.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC:
							cell = String.valueOf(cell1.getNumericCellValue()) ;
							break;
						case HSSFCell.CELL_TYPE_STRING:
							cell = String.valueOf(cell1.getStringCellValue());
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							cell = String.valueOf(cell1.getBooleanCellValue());
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							cell = String.valueOf(cell1.getNumericCellValue());
							break;
						default:
							cell = String.valueOf("");
							break;
						}
						rowValues.add(cell);
					} else {
						rowValues.add("");
					}

				}
				returnList.add(rowValues);
			}
		} catch (IOException e) {
			System.out.println("读取文件出错");
			e.printStackTrace();
		}
		return returnList;
	}
	
	/**
	 * 创建excel文件2007版本
	 * @param tableName
	 * @param column
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static Workbook createExcel(String tableName,List<Column> column, List<List<ColumnData>> list) throws Exception {
		// 创建表
		Workbook wb = new XSSFWorkbook();
		// 工作表名
		String sheetName = WorkbookUtil.createSafeSheetName(tableName);
		Sheet sheet = wb.createSheet(sheetName);

		// 前两行填充字段名称和字段描述信息
		Row nameRow = sheet.createRow(0);
		Row explainRow = sheet.createRow(1);
		CellStyle style = wb.createCellStyle();
		style.setWrapText(true);
		style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		for (int i = 0; i < column.size(); i++) {
			Cell nameCell = nameRow.createCell(i);
			Cell explainCell = explainRow.createCell(i);
			nameCell.setCellValue(column.get(i).getName());
			explainCell.setCellValue(column.get(i).getDescription());
			explainCell.setCellStyle(style);
			sheet.setColumnWidth(i, 5000);
		}

		// 填充数据
		if (list != null) {
			for (int i = 2; i < list.size() + 2; i++) {
				List<ColumnData> datas = list.get(i - 2);
				Row row = sheet.createRow(i);
				for (int j = 0; j < datas.size(); j++) {
					Cell cell = row.createCell(j);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellValue(datas.get(j).getValue());
				}
			}
		}
		return wb;
	}

	public static String write(String type) throws IOException {
		String value = String.valueOf(type).trim();
		String retStr="";
		if("int".equalsIgnoreCase(value)){
			retStr="Integer";
		}else if("String".equalsIgnoreCase(value)){
			retStr="String";
		}else if("float".equalsIgnoreCase(value)){
			retStr="float";
		}else if("long".equalsIgnoreCase(value)){
			retStr="Long";
		}else if("byte".equalsIgnoreCase(value)){
			retStr="Byte";
		}else{
			retStr=value;
		}
		return retStr;
	}
}
