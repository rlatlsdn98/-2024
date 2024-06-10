package view;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

import constants.Constant.SelectionPanel;

public class VSelectionPanel extends JPanel{
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private VIndexPanel vIndexPanel;
	private VLectureTable vLectureTable;
	
	// constructor
	public VSelectionPanel() {
		// layout
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		this.setBorder(border);
		
		// component
		this.vIndexPanel = new VIndexPanel();
		this.add(this.vIndexPanel);
		
		this.vLectureTable = new VLectureTable(SelectionPanel.LECTURE_TABLE_TITLE);
		this.add(vLectureTable);
		
		// associate
		this.vIndexPanel.associate(vLectureTable);
	}

	// initialize
	public void initialize() {
		this.vIndexPanel.initialize();
	}

	// methods
	public VLectureTable getLectureTable() {
		return vLectureTable;
	}

}// class

