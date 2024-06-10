package view;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import constants.Constant.SugangSincheong;
import model.MStudent;


public class VSugangSincheong extends JPanel {
	// attribute
	private static final long serialVersionUID = 1L;
	
	// component
	private VStudentInfoPanel vStudentInfoPanel;
	private VSelectionPanel vSelectionPanel;
	private VControlPanel vControlPanel;
	private VLectureTable vMiridamgiTable;
	private VLectureTable vSingcheongTable;		
	
	// associate
	
	// constructor
	public VSugangSincheong() {
		// layout
	    LayoutManager layoutManager = new GridBagLayout();
		this.setLayout(layoutManager);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH; // 공간 채우기 설정
		gbc.weightx = 1.0; // 가로 가중치 (전체)
		
		// components
		// StudentInfoPanel
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weighty = 0.05;
		this.vStudentInfoPanel = new VStudentInfoPanel();
		this.add(this.vStudentInfoPanel, gbc);
		
		// SelectionPanel
		gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.weighty = 0.9;
		this.vSelectionPanel = new VSelectionPanel();
		this.add(this.vSelectionPanel,gbc);
		
		// ControlPanel1
		gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.1;
		this.vControlPanel = new VControlPanel();
		this.add(this.vControlPanel,gbc);
		
		// MiridamgiTable
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.45;
		this.vMiridamgiTable = new VLectureTable(SugangSincheong.MIRIDAMGI_TITLE);
		this.add(vMiridamgiTable,gbc);

		// SincheongTable
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.45;
		this.vSingcheongTable = new VLectureTable(SugangSincheong.SINCHEONG_TITLE);
		this.add(vSingcheongTable,gbc);
		
		// association
		this.vControlPanel.associate(this.vStudentInfoPanel ,vSelectionPanel.getLectureTable(), this.vMiridamgiTable, this.vSingcheongTable);
		this.vSelectionPanel.getLectureTable().associate(this.vMiridamgiTable, this.vSingcheongTable);
		this.vMiridamgiTable.associate(vSelectionPanel.getLectureTable(), this.vSingcheongTable);
		this.vSingcheongTable.associate(vSelectionPanel.getLectureTable(), this.vMiridamgiTable);
	    }
	
	public void initialize() {
		this.vStudentInfoPanel.initialize();
		this.vSelectionPanel.initialize();
		this.vControlPanel.initialize();
		this.vMiridamgiTable.initialize();
		this.vSingcheongTable.initialize();
	}
	
	public void run() {
		
	}

	public void setStudentInfo(MStudent loginStudent) {
		this.vStudentInfoPanel.setStudentInfo(loginStudent);
	}

}
