package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import constants.Constant.ControlPanel;

public class VControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// component
	private Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private JButton MiridamgiButton;
	private JButton SincheongButton;
	private JButton DeleteButton;
	
	// association
	private VStudentInfoPanel vStudentInfoPanel;
	private VLectureTable vLectureTable;
	private VLectureTable vMiridamgiTable;
	private VLectureTable vSincheongTable;

	// constructor
	public VControlPanel() {
		// layout
		this.setBorder(border);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		ActionHandler actionHandler = new ActionHandler();

		this.MiridamgiButton = new JButton(ControlPanel.MIRIDAMGI_BUTTON_TEXT);
		this.MiridamgiButton.addActionListener(actionHandler);
		this.add(this.MiridamgiButton,gbc);
		
		gbc.gridx++;
		this.SincheongButton = new JButton(ControlPanel.SINCHEONG_BUTTON_TEXT);
		this.SincheongButton.addActionListener(actionHandler);
		this.add(this.SincheongButton, gbc);
		
		gbc.gridx++;
		this.DeleteButton = new JButton(ControlPanel.DELETE_BUTTON_TEXT);
		this.DeleteButton.addActionListener(actionHandler);
		this.add(this.DeleteButton, gbc);
	}
	
	// initialize
	public void initialize() {
		
	}

	// methods
	public void associate(VStudentInfoPanel vStudentInfoPanel, VLectureTable vLectureTable, VLectureTable vMiridamgitable, VLectureTable vSingcheongTable) {
		this.vStudentInfoPanel = vStudentInfoPanel;
		this.vLectureTable = vLectureTable;
		this.vMiridamgiTable = vMiridamgitable;
		this.vSincheongTable = vSingcheongTable;
	}
	
	private class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MiridamgiButton) { // 미리담기 버튼 클릭
				String[] selectedLectureData = vLectureTable.getSelectedLecture();
				if(selectedLectureData != null && !vMiridamgiTable.hasLecture(selectedLectureData)) {
					vMiridamgiTable.addSelectedLecture(selectedLectureData);
				}
			}else if(e.getSource() == SincheongButton) { // 신청 버튼 클릭
				String[] selectedLectureData1 = vLectureTable.getSelectedLecture();
				String[] selectedLectureData2 = vMiridamgiTable.getSelectedLecture();
				if (selectedLectureData1 != null && !vSincheongTable.hasLecture(selectedLectureData1) && checkCredit(selectedLectureData1)) {
					vSincheongTable.addSelectedLecture(selectedLectureData1);
					vStudentInfoPanel.updateSincheongCredit(vSincheongTable.getSincheongCredit());
				}
				if (selectedLectureData2 != null && !vSincheongTable.hasLecture(selectedLectureData2)  && checkCredit(selectedLectureData2)) {
					vSincheongTable.addSelectedLecture(selectedLectureData2);
					vStudentInfoPanel.updateSincheongCredit(vSincheongTable.getSincheongCredit());
				}
			}else if(e.getSource() == DeleteButton) { // 삭제 버튼 클릭
				vMiridamgiTable.deleteSelectedLecture();
				vSincheongTable.deleteSelectedLecture();
				vStudentInfoPanel.updateSincheongCredit(vSincheongTable.getSincheongCredit());
			}
		}
	}
	
	// 신청학점이 신청가능 학점을 초과하는지 체크하는 메소드
	private boolean checkCredit(String[] selectedLectureData) {
		int SelectedLectureDataCredit = Integer.parseInt(selectedLectureData[3]); //선택한 강좌 학점
		int StudentCredit = this.vStudentInfoPanel.getStudentCredit(); // 학생이 신청 가능 학점
		int SincheongCredit = this.vSincheongTable.getSincheongCredit(); // 지금까지 신청한 학점
		if (StudentCredit - SincheongCredit >= SelectedLectureDataCredit) {
			return true;
		}else {
			return false;
		}
	}
}
