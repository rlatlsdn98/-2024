package constants;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Constant {
	
	static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();	
	static ImageIcon icon = new ImageIcon("icon/icon.gif");
	
	public class MainFrame {
		public static final Image ICON = icon.getImage();
		public static final String TITLE = "수강신청시스템";
		public static final int WIDTH = dimension.width * 2/3;
		public static final int HEIGHT = dimension.height * 2/3;
		public static final String LOGIN_PANEL_LINK = "LogInPanel";
		public static final String SUGANGSINCHEONG_LINK = "Sugangsincheong";
	}
	
	public class LoginPanel {
		public static final String ID_LABEL = "ID(사용자학번)";
		public static final String PASSWD_LABEL = "비밀번호";
		public static final int TEXT_SIZE = 15;
		public static final String LOGIN_BUTTON_TEXT = "로그인";
		public static final String FIND_PASSWD_BUTTON_TEXT = "비밀번호 찾기";
		public static final String DIALOG_MESSAGE = "로그인 실패. 아이디와 비밀번호를 확인하세요.";
		public static final String DIALOG_TITLE = "로그인 실패";
		public static final String TEXT_FIELD_CLEAR_UNIT = "";
	}
	
	public class PassWordFindDialog {
		public static final String TITLE = "비밀번호 찾기";
		public static final Image ICON = icon.getImage();
		public static final int WIDTH = dimension.width * 1/4;
		public static final int HEIGHT = dimension.height * 1/4;
		public static final String ID_LABEL = "ID";
		public static final int TEXT_SIZE = 15;
		public static final String NAME_LABEL = "Name";
		public static final String VERIFY_BUTTON_TEXT = "인증";
		public static final String SUCCESS_MESSAGE = "비밀번호 : ";
		public static final String FAIL_MESSAGE = "유효하지 않은 사용자 정보 입니다";
	}
	
	public class Toolbar {
		public static final String LOGOUT_BUTTON_TEXT = "로그아웃";
		public static final String DIALOG_MESSAGE = "로그아웃 하시겠습니까?";
		public static final String DIALOG_TITLE = "확인";
	}
	
	public class SugangSincheong {
		public static final String MIRIDAMGI_TITLE = "미리담기 목록";
		public static final String SINCHEONG_TITLE = "신청 목록";
	}
	
	public class StudentInfoPanel {
		public static final String COLLEGE_LABEL_TEXT = "학과 : ";
		public static final String GRADE_LABEL_TEXT = "학년 : ";
		public static final String CREDIT_LABEL_TEXT = "신청가능 학점 : ";
		public static final String SINCHEONG_CREDIT_LABEL_TEXT = "신청 학점 : ";
	}
	
	public class SelectionPanel {
		public static final String LECTURE_TABLE_TITLE = "Lecture";
	}
	
	public class ControlPanel {
		public static final String MIRIDAMGI_BUTTON_TEXT = "미리담기";
		public static final String SINCHEONG_BUTTON_TEXT = "신청";
		public static final String DELETE_BUTTON_TEXT = "삭제";
	}
	
	public class LectureTable {
		public static final String[] HEADER = {"아이디","강좌명","담당교수","학점","시간"};
		
	}
	
	public class IndexPanel {
		public static final String CAMPUS_TITLE = "Campus";
		public static final String COLLEGE_TITLE = "College";
		public static final String DEPARTEMT_TITLE = "Department";
		public static final String CAMPUS_FILE_LINK = "Campus";
	}
	
	public class IndexTable {
		public static final String[] HEADER = {"아이디", "이름"};
	}
	
	public class DAO_FILE {
		public static final String ROOT_FOLDER = "data/";
		public static final String FILE_EXTENSION = ".txt";
		public static final String STUDENT_FILE_LINK = "student";
		public static final String LINE_SPLIT_UNIT = " ";
	}
	
	public class Index {
		public static final int ID_INDEX = 0;
		public static final int NAME_INDEX = 1;
		public static final int LINK_INDEX = 2;
		public static final int NUM_OF_VARIABLES = 3;
	}
	
	public class Lecture {
		public static final int ID_INDEX = 0;
		public static final int NAME_INDEX = 1;
		public static final int PROF_INDEX = 2;
		public static final int CREDIT_INDEX = 3;
		public static final int TIME_INDEX = 4;
		public static final int NUM_OF_VARIABLES = 5;
	}
	
	public class Student {
		public static final int ID_INDEX = 0;
		public static final int NAME_INDEX = 1;
		public static final int COLLEGE_INDEX = 2;
		public static final int GRADE_INDEX = 3;
		public static final int AVAILABLE_CREDIT_INDEX = 4;
		public static final int PASSWD_INDEX = 5;
	}

}
