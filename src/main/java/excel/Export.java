package excel;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 数据导出到xlsx文件
 * 需要第三方API poi-ooxml
 *
 */
public class Export {
	public static void main(String[] args) {
		try (XSSFWorkbook workbook = new XSSFWorkbook();  //创建工作簿,即一个excel文件
				FileOutputStream fos = new FileOutputStream("D:/poi-sample.xlsx")) {
			
			//在工作簿创建一个名称为sample的工作表
			XSSFSheet sheet = workbook.createSheet("sample");
			//在工作表中添加一行, 参数是行序号 0, 1, 2...如果该行已存在, 将会覆盖原有内容
			XSSFRow row = sheet.createRow(0);
			//在行中添加格子,参数是格子的列序号0, 1, 2...
			XSSFCell cell = row.createCell(0);
			//在格中添加数据
			cell.setCellValue("poi sample");
			//setCellValue()有多个重载,可传入不同类型的参数
			row.createCell(1).setCellValue(2333.333);
			
			//写出到磁盘
			workbook.write(fos);
			System.out.println("写出完毕.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
