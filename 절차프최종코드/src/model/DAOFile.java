package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import constants.Constant.DAO_FILE;
import constants.Constant.Index;
import constants.Constant.Lecture;
import constants.Constant.Student;

public class DAOFile {
	// attributes
	
	// associations
		
	// constructors
	public DAOFile() {
			
	}
	
	// initialize
	public void initialize() {
						
	}
	
	// methods
	// get Campus, College, Department file data
	public Vector<MIndex> getList(String fileName) {
		Vector<MIndex> mIndexList = new Vector<MIndex>();
		try {
			String link = DAO_FILE.ROOT_FOLDER + fileName + DAO_FILE.FILE_EXTENSION;
			File file = new File(link);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				// deserialize
				String line = scanner.nextLine();
				String[] wordList = line.split(DAO_FILE.LINE_SPLIT_UNIT);
				MIndex mindex = new MIndex();
				mindex.setId(wordList[Index.ID_INDEX]);
				mindex.setName(wordList[Index.NAME_INDEX]);
				mindex.setLink(wordList[Index.LINK_INDEX]);
				mIndexList.add(mindex);
			}
			scanner.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mIndexList;
	}
	
	// get Lecture data
	public Vector<MLecture> getLectureList(String fileName) {
		Vector<MLecture> mLectureList = new Vector<MLecture>();
		try {
			String link = DAO_FILE.ROOT_FOLDER + fileName + DAO_FILE.FILE_EXTENSION;
			File file = new File(link);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] wordList = line.split(DAO_FILE.LINE_SPLIT_UNIT);
				MLecture mLecture = new MLecture();
				mLecture.setId(wordList[Lecture.ID_INDEX]);
				mLecture.setName(wordList[Lecture.NAME_INDEX]);
				mLecture.setLectureProf(wordList[Lecture.PROF_INDEX]);
				mLecture.setLectureCredit(wordList[Lecture.CREDIT_INDEX]);
				mLecture.setLectureTime(wordList[Lecture.TIME_INDEX]);
				mLectureList.add(mLecture);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mLectureList;
	}
	
	// get Student data
	public Vector<MStudent> getStudentList(){
		Vector<MStudent> mStudentList = new Vector<MStudent>();
		String fileName = DAO_FILE.ROOT_FOLDER + DAO_FILE.STUDENT_FILE_LINK + DAO_FILE.FILE_EXTENSION;
		File file = new File(fileName);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] wordList = line.split(DAO_FILE.LINE_SPLIT_UNIT);
				MStudent mStudent = new MStudent();
				mStudent.setId(wordList[Student.ID_INDEX]);
				mStudent.setName(wordList[Student.NAME_INDEX]);
				mStudent.setCollege(wordList[Student.COLLEGE_INDEX]);
				mStudent.setGrade(wordList[Student.GRADE_INDEX]);
				mStudent.setAvailableCredits(Integer.parseInt(wordList[Student.AVAILABLE_CREDIT_INDEX]));
				mStudent.setPassword(wordList[Student.PASSWD_INDEX]);
				mStudentList.add(mStudent);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mStudentList;
	}

}// class
