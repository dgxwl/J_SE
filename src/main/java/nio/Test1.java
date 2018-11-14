package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 复制文件
 * @author Administrator
 *
 */
public class Test1 {
	public static void main(String[] args) {
		try {
			copyFileUsingFileChannels("pom.xml", "D:/ppp.xml");
			System.out.println("复制完毕");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copyFileUsingFileChannels(String source, String dest) throws IOException {
		try (FileChannel inputChannel = new FileInputStream(source).getChannel();
				FileChannel outputChannel = new FileOutputStream(dest).getChannel()) {
//			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
			inputChannel.transferTo(0, inputChannel.size(), outputChannel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
