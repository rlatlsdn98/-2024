package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import constants.Constant.Lecture;
import constants.Constant.LectureTable;
import control.CLecture;
import model.MLecture;

public class VLectureTable extends JPanel implements IIndexTable{
	// attribute
	private static final long serialVersionUID = 1L;
	
	// components
	private Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private JLabel title;
	private JScrollPane jScrollPane;
	private JTable table;
	private DefaultTableModel model;
	
	// associations
	Vector<MLecture> mLectureList;
	private VLectureTable vLectureTable1;
	private VLectureTable vLectureTable2;
	public void associate(VLectureTable vLectureTable1, VLectureTable vLectureTable2) {
		this.vLectureTable1 = vLectureTable1;
		this.vLectureTable2 = vLectureTable2;
	}
	
	// 선택한 lecture의 data
	private String[] selectedLectureData; 
	private int selectedRow;
	
	// constructor
	public VLectureTable(String title) {
		// layout
		this.setLayout(new BorderLayout());
		this.setBorder(border);
		
		// components
		this.title = new JLabel(title);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.CENTER);
		this.table = new JTable();
		this.jScrollPane = new JScrollPane();
		
		// Table model
		String[] header = LectureTable.HEADER;
		this.model = new DefaultTableModel(null, header);
		this.table.setModel(this.model);
		
		ClickToSelectLecture clickToSelectLecture = new ClickToSelectLecture();
		this.table.addMouseListener(clickToSelectLecture);
		
		// association
		this.jScrollPane.setViewportView(this.table);
		this.mLectureList = new Vector<MLecture>();
		
		// setComponents
		this.add(this.title, BorderLayout.NORTH);
		this.add(this.jScrollPane, BorderLayout.CENTER);
	}

	// initialize()
	public void initialize() {}

	// show()
	public void show(String link) {
		CLecture cLecture = new CLecture();
		this.mLectureList = cLecture.getList(link);
		this.model.setRowCount(0);
		for(MLecture mLecture : this.mLectureList) {
			String[] row = new String[Lecture.NUM_OF_VARIABLES];
			row[Lecture.ID_INDEX] = String.valueOf(mLecture.getId());
			row[Lecture.NAME_INDEX] = mLecture.getName();
			row[Lecture.PROF_INDEX] = mLecture.getLectureProf();
			row[Lecture.CREDIT_INDEX] = mLecture.getLectureCredit();
			row[Lecture.TIME_INDEX] = mLecture.getLectureTime();
			this.model.addRow(row);
		}
	}
	
	// TableModel에서 마우스로 클릭한 Lecture의 data를 String[]에 저장하는 Method
	private class ClickToSelectLecture implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {			
			int row = table.getSelectedRow();
			setSelectedLecture(row);
			vLectureTable1.clearTable();
			vLectureTable2.clearTable();
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
	

	// VLectureTable의 선택된 Lecture를 selectedLectureData에 저장하는 Method
	public void setSelectedLecture(int row) {
		String[] rowData = new String[table.getColumnCount()];
		for(int i=0; i<table.getColumnCount(); i++) {
			rowData[i] = (String) table.getValueAt(row, i);
		}
		this.selectedLectureData = rowData;
		this.selectedRow = row;
	}

	private void clearTable() {
		this.table.clearSelection();
		this.selectedLectureData = null;
	}

	// VIndexPanel의 VLectureTable의 선택된 Lecture를 ControlPanel1이 가져오는 Method
	public String[] getSelectedLecture() {
		return this.selectedLectureData;
	}

	// ControlPanel1에 저장된 선택된 Lecture의 데이터를 tableModel에 저장하는 Method
	public void addSelectedLecture(String[] selectedLectureData) {
		this.model.addRow(selectedLectureData);
	}

	// 중복 Lecture 검사 
	public boolean hasLecture(String[] selectedLectureData) {
		int rowCount = this.model.getRowCount();
		int columnCount = this.model.getColumnCount();
		for (int i = 0; i < rowCount; i++) {
	        boolean duplicate = true;
	        for (int j = 0; j < columnCount; j++) {
	            if (!model.getValueAt(i, j).equals(selectedLectureData[j])) {
	                duplicate = false;
	                break;
	            }
	        }
	        if (duplicate) {
	            return true;
	        }
	    }
	    return false;
	}

	// 선택된 Lecture를 Table에서 삭제하는 메소드
	public void deleteSelectedLecture() {
		if (this.selectedLectureData != null) {
			this.model.removeRow(this.selectedRow);
			this.selectedLectureData = null;
		}
	}

	public void setSelectedLectureDataNull() {
		this.selectedLectureData = null;
	}

	public int getSincheongCredit() {
		int SincheongCredit = 0;
		for(int row = 0; row < this.model.getRowCount(); row++) {
			SincheongCredit += Integer.parseInt((String) this.model.getValueAt(row, 3));
		}
		return SincheongCredit;
	}
}
