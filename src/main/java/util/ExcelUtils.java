package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private ExcelUtils() {
	}

	/**
	 * 导出Excel文件为字节数组
	 * 
	 * @param listData
	 * @param mapHeader
	 * @return Excel文件字节数组
	 * @throws IOException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws InvocationTargetException
	 */
	public byte[] export2XlsWithInfo(List<?> listData, LinkedHashMap<String, ExportInfo> mapHeader)
			throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, EncryptedDocumentException, InvalidFormatException, InvocationTargetException {

		int rowIndex = 0;
		int colIndex = 0;
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();

		if (sheet == null) {
			sheet = wb.createSheet();
		}

		Row r = sheet.createRow(0);
		for (Map.Entry<String, ExportInfo> entry : mapHeader.entrySet()) {
			ExportInfo info = entry.getValue();
			Cell cell = r.createCell(colIndex);
			cell.setCellValue(info.getColumnName());
			colIndex++;
		}
		rowIndex++;

		for (int i = 0; i < listData.size(); i++) {
			Object model = listData.get(i);
			colIndex = 0;
			Row row = sheet.createRow(rowIndex);
			for (Map.Entry<String, ExportInfo> entry : mapHeader.entrySet()) {
				Cell cell = row.createCell(colIndex);
				String colname = entry.getKey();
				ExportInfo exportInfo = entry.getValue();
				Method method;
				try {
					method = model.getClass()
							.getMethod("get" + colname.substring(0, 1).toUpperCase() + colname.substring(1));
					Object val = method.invoke(model, new Object[0]);
					String value = exportInfo.getValue(val);
					cell.setCellValue(value);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
				colIndex++;
			}
			rowIndex++;
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		wb.write(out);
		wb.close();
		out.close();
		return out.toByteArray();
	}
}
