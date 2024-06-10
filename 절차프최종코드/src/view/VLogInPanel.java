package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.Constant.LoginPanel;
import control.CStudent;
import model.MStudent;

public class VLogInPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	// component
	private VMainFrame vMainFrame;
	public void associate(VMainFrame vMainFrame) { this.vMainFrame = vMainFrame; }
	private CStudent cStudent;
	private Vector<MStudent> studentList;
	private MStudent LoginStudent;
	// ID
	JLabel idLabel;
	JTextField idField;
	// Password
	JLabel passwordLabel;
	JPasswordField passwordField;
	// Button
	JButton loginButton;
	JButton findPasswordButton;
	
	// constructor
	public VLogInPanel() {
		// layout
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		// components
		this.cStudent = new CStudent();
		this.studentList = this.cStudent.getList();
		// EventHandler
		ActionHandler actionHandler = new ActionHandler();
		EnterKeyListener enterKeyListener = new EnterKeyListener();
		
		// ID Label
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		this.idLabel = new JLabel(LoginPanel.ID_LABEL);
		this.add(this.idLabel, gbc);
		// ID Field
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		this.idField = new JTextField(LoginPanel.TEXT_SIZE);
		this.idField.addKeyListener(enterKeyListener);
		this.add(this.idField, gbc);
		// Password Label
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		this.passwordLabel = new JLabel(LoginPanel.PASSWD_LABEL);
		this.add(this.passwordLabel, gbc);
		// Password Field
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.passwordField = new JPasswordField(LoginPanel.TEXT_SIZE);
		this.passwordField.addKeyListener(enterKeyListener);
		this.add(this.passwordField, gbc);
		// Login Button
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		this.loginButton = new JButton(LoginPanel.LOGIN_BUTTON_TEXT);
		this.loginButton.addActionListener(actionHandler);
		this.add(this.loginButton, gbc);
		// Find Password Button
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		this.findPasswordButton = new JButton(LoginPanel.FIND_PASSWD_BUTTON_TEXT);
		this.findPasswordButton.addActionListener(actionHandler);
		this.add(this.findPasswordButton, gbc);
	}
	
	// initialize
	public void initialize() {
	}
	
	// methods
	
	// 마우스 클릭 이벤트
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginButton) { // 로그인 버튼 클릭시
				if(checkLogIn()) {					
					vMainFrame.switchToSugangsincheongPanel(LoginStudent);
				}else {
					showErrorDialog();
				}
			}else if (e.getSource() == findPasswordButton) { // 비밀번호 찾기 버튼 클릭시
				findPassword(studentList);
			}
		}
	}
	
	// Enter키 입력 이벤트
	private class EnterKeyListener implements KeyListener{
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(checkLogIn()) {					
					vMainFrame.switchToSugangsincheongPanel(LoginStudent);
				}else {
					showErrorDialog();
				}
			}
		}
		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {}
	}
	
	// 로그인 정보가 일치하면 True, 불일치 False
	private boolean checkLogIn() {
		String inputId = this.idField.getText();
		String inputPasswd = String.valueOf(this.passwordField.getPassword());
		for(MStudent mStudent : this.studentList) {
			if (inputId.equals(mStudent.getId()) && inputPasswd.equals(mStudent.getPassword())) {
				this.LoginStudent = mStudent;
				return true;
			}
		}
		return false;
	}
	
	// 로그인 실패시 화면에 에러메시지 다이얼로그 출력
	private void showErrorDialog() {
		JOptionPane.showMessageDialog(this, LoginPanel.DIALOG_MESSAGE, LoginPanel.DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
	}
	
	// 로그인 버튼 클릭시 실행되는 메소드
	private void findPassword(Vector<MStudent> studentList) {
		VPassWordFindDialog vPassWordFindDialog = new VPassWordFindDialog(studentList);
	}
	
	// 로그인 TextField 전부 초기화
	public void Reset() {
		this.idField.setText(LoginPanel.TEXT_FIELD_CLEAR_UNIT);
		this.passwordField.setText(LoginPanel.TEXT_FIELD_CLEAR_UNIT);
	}
}// class
