package designpattern.structrual.facade;

/**
 * Facade外观(门面)类
 * @author Administrator
 *
 */
public class ComputerFacade {
	
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;
	
	public ComputerFacade() {
		cpu = new CPU();
		memory = new Memory();
		hardDrive = new HardDrive();
	}
	
	public void start() {
		cpu.process();
		memory.load();
		hardDrive.read();
	}
}
