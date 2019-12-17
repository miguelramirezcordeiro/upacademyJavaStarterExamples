package pt.upacademy.TISM.States;

import pt.upacademy.Examples.ScannerUtils.ScannerUtils;

public abstract class State {
	public static final ScannerUtils sc = new ScannerUtils();

	public abstract int run();
}
