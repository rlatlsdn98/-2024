package control;

import java.util.Vector;

import model.DAOFile;
import model.MIndex;

public class CIndex {
    
	private DAOFile daoFile;
	
	public CIndex() {
		
	}

	public Vector<MIndex> getList(String fileName) {
		this.daoFile = new DAOFile();
		Vector<MIndex> mCampusList = this.daoFile.getList(fileName);
		return mCampusList;
	}
}
