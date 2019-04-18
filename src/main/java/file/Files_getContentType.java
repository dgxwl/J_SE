package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * 根据文件后缀获得对应的ContentType
 * @author Administrator
 *
 */
public class Files_getContentType {
	public static void main(String[] args) throws IOException {
		File file = new File("./abc.docx");
		String contentType = Files.probeContentType(file.toPath());
		System.out.println(contentType);
	}
}
