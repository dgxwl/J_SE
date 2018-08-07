package exception;

/**
 * 当出现异常时会对当前栈帧进行快照并生成异常对象, 这是一个耗时的操作;
 * 对性能要求比较高时需要进行优化.
 * @author Administrator
 *
 */
public class Exception_consume extends Exception {
	private static final long serialVersionUID = 1L;

	/*
	 * fillInStackTrace()在Throwable中的定义是synchronize的,
	 * 是导致耗时的一个原因; 如果不需要关注栈信息, 重写该方法可以提升性能.
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
}
