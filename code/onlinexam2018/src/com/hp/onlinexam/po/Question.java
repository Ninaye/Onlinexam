package com.hp.onlinexam.po;

public class Question {
	private int qid;
	private int courseId;
	private int queType;
	private String queTitle;
	private String choiceA;
	private String choiceB;
	private String choiceC;
	private String choiceD;
	private String ans;
	private int queExist;

	public Question() {
	}

	public Question(int courseId, int queType, String queTitle, String choiceA, String choiceB, String choiceC,
			String choiceD, String ans, int queExist) {
		this.courseId = courseId;
		this.queType = queType;
		this.queTitle = queTitle;
		this.choiceA = choiceA;
		this.choiceB = choiceB;
		this.choiceC = choiceC;
		this.choiceD = choiceD;
		this.ans = ans;
		this.queExist = queExist;
	}

	public Question(int qid, int courseId, int queType, String queTitle, String choiceA, String choiceB, String choiceC,
			String choiceD, String ans, int queExist) {
		this.qid = qid;
		this.courseId = courseId;
		this.queType = queType;
		this.queTitle = queTitle;
		this.choiceA = choiceA;
		this.choiceB = choiceB;
		this.choiceC = choiceC;
		this.choiceD = choiceD;
		this.ans = ans;
		this.queExist = queExist;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getQueType() {
		return queType;
	}

	public void setQueType(int queType) {
		this.queType = queType;
	}

	public String getQueTitle() {
		return queTitle;
	}

	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}

	public String getChoiceA() {
		return choiceA;
	}

	public void setChoiceA(String choiceA) {
		this.choiceA = choiceA;
	}

	public String getChoiceB() {
		return choiceB;
	}

	public void setChoiceB(String choiceB) {
		this.choiceB = choiceB;
	}

	public String getChoiceC() {
		return choiceC;
	}

	public void setChoiceC(String choiceC) {
		this.choiceC = choiceC;
	}

	public String getChoiceD() {
		return choiceD;
	}

	public void setChoiceD(String choiceD) {
		this.choiceD = choiceD;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public int getQueExist() {
		return queExist;
	}

	public void setQueExist(int queExist) {
		this.queExist = queExist;
	}

	@Override
	public String toString() {
		return "Questions [qid=" + qid + ", courseId=" + courseId + ", queType=" + queType + ", queTitle=" + queTitle
				+ ", choiceA=" + choiceA + ", choiceB=" + choiceB + ", choiceC=" + choiceC + ", choiceD=" + choiceD
				+ ", ans=" + ans + ", queExist=" + queExist + "]";
	}

}