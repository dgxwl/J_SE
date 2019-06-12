package pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * 使用itext api在pdf中插入文字
 * 参考:
 * https://www.cnblogs.com/qinxu/p/8270310.html
 * https://blog.csdn.net/zhuce0001/article/details/51964860
 * 
 * <dependency> <groupId>com.itextpdf</groupId>
 * <artifactId>itextpdf</artifactId> <version>5.5.13</version> </dependency>
 * 
 * @author Administrator
 *
 */
public class PdfAddTextDemo {
	public static void main(String[] args) throws Exception {
		generatePDF("F:/qweqwe.pdf", "F:/qweqwe2.pdf", "名字", "286823333333", "2019.05.05");
	}
	
	/** 指定插入文字的字体文件路径(找操作系统里自带的黑体ttf文件放入项目中, 程序中需要读取) */
	private static final String fontPath = "./font/simhei.ttf";

	/**
	 * 读取pdf文件, 插入文字后生成新的pdf文件
	 * @param pdfPath 待处理pdf文件路径
	 * @param newPDFPath 处理后的新文件路径
	 * @param name 待插入文字参数之一
	 * @param phone 待插入文字参数之一
	 * @param date 待插入文字参数之一
	 */
	public static void generatePDF(String pdfPath, String newPDFPath, String name, String phone, String date) {
		PdfReader reader = null;
		PdfStamper stamper = null;
		try {
			//创建pdf读入流
			reader = new PdfReader(pdfPath);
			//根据pdfreader创建pdfStamper, 用来生成新的pdf
			stamper = new PdfStamper(reader, new FileOutputStream(newPDFPath));
			
			//创建字体对象指定字体
			BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			//baseFont不支持字体样式设定.但是font字体要求操作系统支持此字体会带来移植问题.
			Font font = new Font(bf, 10);
			font.setStyle(Font.BOLD);
			font.getBaseFont();
			PdfContentByte overContent;
			
			int page = 1;
			overContent = stamper.getOverContent(page);
			//开始写入文本
			overContent.beginText();
			//设置字体和大小
			overContent.setFontAndSize(font.getBaseFont(), 10);
			//设置字体颜色
//			over.setColorFill(new BaseColor(0, 110, 107, 100));
			com.itextpdf.text.pdf.PdfGState gState = new PdfGState();
			gState.setStrokeOpacity(0.1f);
			overContent.setGState(gState);
			/*
			 * void showTextAligned(int alignment, String text, float x, float y, float rotation)
			 * alignment:设置对齐方式
			 * text:要插入的文本
			 * x/y:插入位置坐标, 原点在左下角
			 * rotation:字体逆时针旋转角度
			 */
			overContent.showTextAligned(PdfContentByte.ALIGN_LEFT, name, 385, 738, 0);
			overContent.showTextAligned(PdfContentByte.ALIGN_LEFT, phone, 80, 710, 90);
			overContent.showTextAligned(PdfContentByte.ALIGN_LEFT, date, 363, 710, 180);
			overContent.endText();
			
			stamper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
