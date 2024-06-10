package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import constants.Constant.IndexPanel;

public class VIndexPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	
	// components
	private VIndexTable vCampus;
	private VIndexTable vCollege;
	private VIndexTable vDepartment;

	// constructor
	VIndexPanel() {
		this.setLayout(new GridBagLayout());
		
		// components
		this.vCampus = new VIndexTable(IndexPanel.CAMPUS_TITLE);
		this.add(vCampus);
		
		this.vCollege = new VIndexTable(IndexPanel.COLLEGE_TITLE);
		this.add(vCollege);
		
		this.vDepartment = new VIndexTable(IndexPanel.DEPARTEMT_TITLE);
		this.add(vDepartment);
		
		// associations
		this.vCampus.setNext(vCollege);
		this.vCollege.setNext(vDepartment);
		
		//Panel에 Component 추가
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;

		JPanel topPanel = new JPanel(new GridLayout(1, 3));
		topPanel.add(this.vCampus);
		topPanel.add(this.vCollege);
		topPanel.add(this.vDepartment);

		gbc.weighty = 0.5; // 상단 패널 가중치
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(topPanel, gbc);
	}

	// initialize
	public void initialize() {
		this.vCampus.initialize();
		this.vCollege.initialize();
		this.vDepartment.initialize();
		this.vCampus.show(IndexPanel.CAMPUS_FILE_LINK);
	}

	// methods
	public void associate(VLectureTable vLectureTable) {
		this.vDepartment.setNext(vLectureTable);
	}
	
}
