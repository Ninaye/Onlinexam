package com.hp.onlinexam.service.teacher;

import java.util.List;

import com.hp.onlinexam.dao.teacher.IPapersDao;
import com.hp.onlinexam.dao.teacher.PapersDao;
import com.hp.onlinexam.po.Paper;

public class PaperService implements IPaperService{

	private IPapersDao pd = new PapersDao();
	
	@Override
	public void save(Paper paper) {
		pd.save(paper);
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		return pd.getPaperByStudentId(studentId);
	}

	@Override
	public List getPaperCompare(int teaId) {
		return pd.getPaperCompare(teaId);
	}

}
