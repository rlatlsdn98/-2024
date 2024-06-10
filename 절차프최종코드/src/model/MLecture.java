package model;

public class MLecture {

	private String id;
	private String name;
	private String LectureProf;
	private String LectureCredit;
	private String LectureTime;
	
	public MLecture() {}
	
	// getter & setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLectureProf() {
		return LectureProf;
	}
	public void setLectureProf(String lectureProf) {
		LectureProf = lectureProf;
	}
	public String getLectureCredit() {
		return LectureCredit;
	}
	public void setLectureCredit(String lectureCredit) {
		LectureCredit = lectureCredit;
	}
	public String getLectureTime() {
		return LectureTime;
	}
	public void setLectureTime(String lectureTime) {
		LectureTime = lectureTime;
	}
}
