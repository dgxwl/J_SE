package pdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * 使用itext api在pdf中插入图片
 * 参考https://www.cnblogs.com/qinxu/p/8270310.html
 * 
 * <dependency>
		<groupId>com.itextpdf</groupId>
		<artifactId>itextpdf</artifactId>
		<version>5.5.13</version>
	</dependency>
 * 
 * @author Administrator
 *
 */
public class PdfAddImageDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream fos = new FileInputStream("F:/qweqwe.png");
		byte[] bs = new byte[fos.available()];
		fos.read(bs);
		
		generatePDF("F:\\qweqwe.pdf", "F:\\qweqwe2.pdf", bs);
		
		fos.close();
	}

	public static void generatePDF(String pdfPath, String newPDFPath, String imagePath) {
		PdfReader reader = null;
		PdfStamper stamper = null;
		try {
			//创建pdf读入流
			reader = new PdfReader(pdfPath);
			//根据pdfreader创建pdfStamper, 用来生成新的pdf
			stamper = new PdfStamper(reader, new FileOutputStream(newPDFPath));

			//获取pdf总页数(页码取值范围: 1~lastPage)
			int lastPage = reader.getNumberOfPages();

			/*
			 * PdfContentByte PdfStamper.getOverContent(int pageNum)
			 * 获取一个PdfContentByte实例, 操作该实例可在原始文档的页面上增加内容(覆盖原内容)
			 */
			PdfContentByte overContent = stamper.getOverContent(lastPage);
			//PdfContentByte underContent = stamper.getUnderContent(lastPage);
			
			//com.itextpdf.text.Image 待插入pdf中的图片类
			Image image = Image.getInstance(imagePath);
			
			/*
			 * Rectangle PdfReader.getPageSize(int index)从reader中获取文件指定页的尺寸
			 */
			Rectangle pageSize = reader.getPageSize(lastPage);
			
			//getWidth()获得页面宽度
			float width = pageSize.getWidth();
			//getHeight()获得页面高度
			float height = pageSize.getHeight();
			
			/*
			 * void Image.setAbsolutePosition(float absoluteX, float absoluteY)
			 * 传入x, y坐标参数(原点在左下角), 指定待插入图片在页面中的位置
			 */
			image.setAbsolutePosition(width / 2, height * 0.1f);
			//设置插入图片的缩放大小
			image.scaleToFit(50, 50);
			//将图片添加到overContent中, 插入完成
			overContent.addImage(image);

			stamper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void generatePDF(String pdfPath, String newPDFPath, byte[] imageBytes) {
		PdfReader reader = null;
		PdfStamper stamper = null;
		try {
			//创建pdf读入流
			reader = new PdfReader(pdfPath);
			//根据pdfreader创建pdfStamper, 用来生成新的pdf
			stamper = new PdfStamper(reader, new FileOutputStream(newPDFPath));

			//获取pdf总页数(页码取值范围: 1~lastPage)
			int lastPage = reader.getNumberOfPages();

			/*
			 * PdfContentByte PdfStamper.getOverContent(int pageNum)
			 * 获取一个PdfContentByte实例, 操作该实例可在原始文档的页面上增加内容(覆盖原内容)
			 */
			PdfContentByte overContent = stamper.getOverContent(lastPage);
			//PdfContentByte underContent = stamper.getUnderContent(lastPage);
			
			//com.itextpdf.text.Image 待插入pdf中的图片类
			Image image = Image.getInstance(imageBytes);
			
			/*
			 * Rectangle PdfReader.getPageSize(int index)从reader中获取文件指定页的尺寸
			 */
			Rectangle pageSize = reader.getPageSize(lastPage);
			
			//getWidth()获得页面宽度
			float width = pageSize.getWidth();
			//getHeight()获得页面高度
			float height = pageSize.getHeight();
			
			/*
			 * void Image.setAbsolutePosition(float absoluteX, float absoluteY)
			 * 传入x, y坐标参数(原点在左下角), 指定待插入图片在页面中的位置
			 */
			image.setAbsolutePosition(width / 2, height * 0.1f);
			//设置插入图片的缩放大小
			image.scaleToFit(50, 50);
			//将图片添加到overContent中, 插入完成
			overContent.addImage(image);

			stamper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
