package nio;

import java.nio.ByteBuffer;

/**
 * Buffer: 本质是一块可以读写数据的连续的内存块, 可通过封装好的Buffer对象操作该内存;
 * Buffer根据数据类型分类(对应除boolean外的数据类型, 加上MappedByteBuffer):
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * MappedByteBuffer
 * @author Administrator
 *
 */
public class BufferDemo {
	public static void main(String[] args) {
		/*
		 * ByteBuffer allocate(int capacity)
		 * 获取
		 */
		ByteBuffer buff = ByteBuffer.allocate(1024);
	}
}
