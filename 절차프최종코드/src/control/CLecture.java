package control;

import java.util.Vector;

import model.DAOFile;
import model.MLecture;

public class CLecture {
	
	private DAOFile daoFile;
	
	public CLecture() {
		
	}
	
	public Vector<MLecture> getList(String fileName){
		this.daoFile = new DAOFile();
		Vector<MLecture> mLectureList = this.daoFile.getLectureList(fileName);
		return mLectureList;
	}

}
