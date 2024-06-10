package control;

import java.util.Vector;

import model.DAOFile;
import model.MStudent;

public class CStudent {
	
	private DAOFile daoFile;
	
	public CStudent() {
		
	}
	
	public Vector<MStudent> getList(){
		this.daoFile = new DAOFile();
		return this.daoFile.getStudentList();
	}

}
