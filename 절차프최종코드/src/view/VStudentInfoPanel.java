package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import constants.Constant.StudentInfoPanel;
import model.MStudent;

public class VStudentInfoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	// attribute
	
	// components
	private MStudent LoginStudent;
	private JLabel CollegeLabel;
	private JLabel GradeLabel;
	private JLabel CreditLabel;
	private JLabel SincheongCreditLabel;
	
	private int StudentCredit;
	private int SincheongCredit = 0;
	
	// constructor
	public VStudentInfoPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridx = 0;
		gbc.weightx = 0.25;
		this.CollegeLabel = new JLabel();
		setTextCenter(this.CollegeLabel);
		this.add(this.CollegeLabel, gbc);
		
		gbc.gridx = 1;
		this.GradeLabel = new JLabel();
		setTextCenter(this.GradeLabel);
		this.add(this.GradeLabel, gbc);
		
		gbc.gridx= 2;
		this.CreditLabel = new JLabel();
		setTextCenter(this.CreditLabel);
		this.add(this.CreditLabel, gbc);
		
		gbc.gridx = 3;
		this.SincheongCreditLabel = new JLabel(StudentInfoPanel.SINCHEONG_CREDIT_LABEL_TEXT + this.SincheongCredit);
		setTextCenter(this.SincheongCreditLabel);
		this.add(this.SincheongCreditLabel,gbc);
	}
	

	// initialize
	public void initialize() {
		
	}

	// methods
	// JLabel의 Text를 가운데로 정렬
	private void setTextCenter(JLabel JLabel) {
		JLabel.setVerticalAlignment(SwingConstants.CENTER);
		JLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	// Login한 Student의 확과, 학년, 신청가능 학점 data를 Label에 표시하는 메소드
	public void setStudentInfo(MStudent loginStudent) {
		this.LoginStudent = loginStudent;
		this.CollegeLabel.setText(StudentInfoPanel.COLLEGE_LABEL_TEXT + this.LoginStudent.getCollege());
		this.GradeLabel.setText(StudentInfoPanel.GRADE_LABEL_TEXT + this.LoginStudent.getGrade());
		this.CreditLabel.setText(StudentInfoPanel.CREDIT_LABEL_TEXT + this.LoginStudent.getAvailableCredits());
		this.StudentCredit = this.LoginStudent.getAvailableCredits();
	}

	// return Login Student's Available Credit
	public int getStudentCredit() {
		return this.StudentCredit;
	}

	// 신청한 학점 업데이트
	public void updateSincheongCredit(int sincheongCredit) {
		this.SincheongCreditLabel.setText(StudentInfoPanel.SINCHEONG_CREDIT_LABEL_TEXT + sincheongCredit);
	}
}
