package view;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.Constant.MainFrame;
import model.MStudent;


public class VMainFrame extends JFrame {
	// attributes
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private JPanel SugangsincheongCard;
	
    // components
	private VLogInPanel vLogInPanel;
	private VToolbar vToolbar;
	private VSugangSincheong vSugangSincheong;
	
	// constructor
	public VMainFrame() throws HeadlessException, FileNotFoundException {
		// layout
		this.cardLayout = new CardLayout();
		this.setLayout(this.cardLayout);
		this.SugangsincheongCard = new JPanel(new BorderLayout()); // 수강신청 화면
		
		// attributes (제목, 아이콘, 프레임 사이즈, 종료기능)
		this.setTitle(MainFrame.TITLE);
		this.setSize(MainFrame.WIDTH,MainFrame.HEIGHT);
		this.setIconImage(MainFrame.ICON);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// components
		this.vLogInPanel = new VLogInPanel();
		this.vLogInPanel.associate(this);
		this.add(this.vLogInPanel, MainFrame.LOGIN_PANEL_LINK);
		
		this.vSugangSincheong = new VSugangSincheong();
		this.vToolbar = new VToolbar();
		this.SugangsincheongCard.add(this.vToolbar, BorderLayout.NORTH);
		this.SugangsincheongCard.add(this.vSugangSincheong, BorderLayout.CENTER);
		this.add(this.SugangsincheongCard, MainFrame.SUGANGSINCHEONG_LINK);
		
		// associate
		this.vToolbar.associate(this);
	}
	
	// methods
	public void initialize() {
		this.vLogInPanel.initialize();
		this.vSugangSincheong.initialize();
	}

	// 메인 화면을 수강신청 화면으로 바꾸기
	public void switchToSugangsincheongPanel(MStudent loginStudent) {
		this.cardLayout.show(this.getContentPane(), MainFrame.SUGANGSINCHEONG_LINK);
		this.vSugangSincheong.setStudentInfo(loginStudent);
	}

	// 메인 화면을 로그인 화면으로 바꾸는 메소드
	public void switchToLogInPanel() {
		this.cardLayout.show(this.getContentPane(), MainFrame.LOGIN_PANEL_LINK);
	}

	// 로그인 화면의 TextField를 초기화 
	public void LogInReset() {
		this.vLogInPanel.Reset();
	}
}