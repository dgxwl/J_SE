package pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import com.itextpdf.text.pdf.PdfReader;

/**
 * pdf转图片
 * 参考https://blog.csdn.net/thc1987/article/details/76457474
 * 
 * <dependency>
			<groupId>org.apache.pdfbox</groupId>
			<artifactId>fontbox</artifactId>
			<version>2.0.12</version>
		</dependency>
		<dependency>
			<groupId>org.apache.pdfbox</groupId>
			<artifactId>pdfbox</artifactId>
			<version>2.0.12</version>
		</dependency>
 * 
 * @author Administrator
 *
 */
public class PdfToImageDemo {
	public static void main(String[] args) {
		pdf2Image("F:/90935351725.pdf", "F:/", 250);
	}

	/**
	 * pdf转图片
	 * @param PdfFilePath  pdf文件路径
	 * @param dstImgFolder 存放生成图片的目录
	 * @param dpi 越大转换后越清晰，相对转换速度越慢
	 */
	public static void pdf2Image(String PdfFilePath, String dstImgFolder, int dpi) {
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		File file = new File(PdfFilePath);
		PDDocument pdDocument;
		try {
			String imgPDFPath = file.getParent();
			int dot = file.getName().lastIndexOf('.');
			String imagePDFName = file.getName().substring(0, dot);  //获取图片文件名
			String imgFolderPath = null;
			if (dstImgFolder.equals("")) {
				imgFolderPath = imgPDFPath + File.separator + imagePDFName;  //获取图片存放的文件夹路径
			} else {
				imgFolderPath = dstImgFolder + File.separator + imagePDFName;
			}

			if (createDirectory(imgFolderPath)) {
				pdDocument = PDDocument.load(file);
				PDFRenderer renderer = new PDFRenderer(pdDocument);
				PdfReader reader = new PdfReader(PdfFilePath);
				int pages = reader.getNumberOfPages();
				StringBuffer imgFilePath = null;
				for (int i = 0; i < pages; i++) {
					String imgFilePathPrefix = imgFolderPath + File.separator + imagePDFName;
					imgFilePath = new StringBuffer();
					imgFilePath.append(imgFilePathPrefix);
					imgFilePath.append("_");
					imgFilePath.append(String.valueOf(i + 1));
					imgFilePath.append(".png");
					File dstFile = new File(imgFilePath.toString());
					BufferedImage image = renderer.renderImageWithDPI(i, dpi);
					ImageIO.write(image, "png", dstFile);
				}
			} else {
				throw new RuntimeException("创建目录失败");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean createDirectory(String folder) {
		File dir = new File(folder);
		if (dir.exists()) {
			return true;
		} else {
			return dir.mkdirs();
		}
	}
}
