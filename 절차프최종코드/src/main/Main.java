package main;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import view.VMainFrame;

public class Main {
	// attributes
	
	// components
	private VMainFrame VMainFrame;
	
	
	// associations
	
	// constructors
	public Main() throws HeadlessException, FileNotFoundException {
		this.VMainFrame = new VMainFrame();
		this.VMainFrame.setVisible(true);
	}
	public void initialize() {
		this.VMainFrame.initialize();
	}
	// methods
	public void run() {
	
	}
    // main
	public static void main(String[] args) throws HeadlessException, FileNotFoundException {
		Main main = new Main();
		main.initialize();
		main.run();
	}
}
