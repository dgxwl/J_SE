package excel;

import java.io.File;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * xlsx文件内容导入程序
 *
 */
public class Import {
	public static void main(String[] args) {
		File xlsxFile = new File("D:/poi-sample.xlsx");
		if (!xlsxFile.exists()) {
			System.out.println("文件不存在");
			System.exit(0);
		}
		
		try (
				//读取工作簿(表格文件)
				XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile)
		) {
			//获取工作表
			XSSFSheet sheet = workbook.getSheetAt(0);
			//获取有数据的最后一行的序号
			int lastRowNum = sheet.getLastRowNum();
			
			for (int i = 0; i <= lastRowNum; i++) {
				//获取行
				XSSFRow row = sheet.getRow(i);
				if (row == null) {  //跳过空行
					continue;
				}
				//获取列数
				int lastCellNum = row.getLastCellNum();
				
				for (int j = 0; j < lastCellNum; j++) {
					//获取行中格子
					XSSFCell cell = row.getCell(j);
					if (cell == null) {  //跳过空格子
						continue;
					}
					//如果想读取为字符串、而数据为numeric的话,需要先指定cell中数据类型,不然直接报错
					cell.setCellType(CellType.STRING);
					//获取格子内容; 还有getBooleanCellValue()等方法, 可按类型获取值
					String cellValue = cell.getStringCellValue();
					System.out.print(cellValue + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
