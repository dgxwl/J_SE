package designpattern.creational.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Outer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Inner inner;

	public Outer(Inner inner) {
		super();
		this.inner = inner;
	}
	
	/**
	 * 自定义方法，实现了深克隆.
	 * @return
	 */
	public Outer myClone() {
		Outer outer = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			outer = (Outer) ois.readObject();
			
			bos.close();
			oos.close();
			bis.close();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outer;
	}

	@Override
	public String toString() {
		return "Outer [inner=" + inner + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inner == null) ? 0 : inner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Outer other = (Outer) obj;
		if (inner == null) {
			if (other.inner != null)
				return false;
		} else if (!inner.equals(other.inner))
			return false;
		return true;
	}
	
	
}
