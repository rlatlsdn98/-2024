package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.Constant.Index;
import constants.Constant.IndexTable;
import control.CIndex;
import model.MIndex;

public class VIndexTable extends JPanel implements IIndexTable{
	// attribute
	private static final long serialVersionUID = 1L;
	
	// components
	private JLabel title;
	private JScrollPane jScrollPane;
	private JTable table;
	private DefaultTableModel model;
	Vector<MIndex> mIndexList = new Vector<MIndex>();
	public String LectureLink;
	
	// associations
	private IIndexTable next;
	public void setNext(IIndexTable next) { this.next = next; }
	
	// constructor
	public VIndexTable(String title) {
		// layout
		this.setLayout(new BorderLayout());		
		
		// components
		this.title = new JLabel(title);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.CENTER);
		this.table = new JTable();
		this.jScrollPane = new JScrollPane();
		
		// Table model
		String[] header = IndexTable.HEADER;
		this.model =new DefaultTableModel(null, header);
		this.table.setModel(model);
		
		// association
		MouseHandler mouseHandler = new MouseHandler();
		this.table.addMouseListener(mouseHandler);
		this.jScrollPane.setViewportView(this.table);
		
		// setComponents
		this.add(this.title, BorderLayout.NORTH);
		this.add(this.jScrollPane, BorderLayout.CENTER);
	}
	
	// initialize
	public void initialize() {}
	
	// methods
	// show()
	public void show(String fileName) {
		CIndex cIndex = new CIndex();
		this.mIndexList = cIndex.getList(fileName);
		this.model.setRowCount(0);
		for (MIndex mIndex: mIndexList) {
			String[] row = new String[Index.NUM_OF_VARIABLES-1];
			row[Index.ID_INDEX] = String.valueOf(mIndex.getId());
			row[Index.NAME_INDEX] = mIndex.getName();
			this.model.addRow(row);
		}
		this.showNext(0);
	}
	
	// showNext()
	private void showNext(int rowIndex) {
		if(this.next != null) {
			this.next.show(this.mIndexList.get(rowIndex).getLink());
		}
	}
	
	// MousetListener
	private class MouseHandler implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {			
				int row = table.getSelectedRow();
				showNext(row);
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

}// Class