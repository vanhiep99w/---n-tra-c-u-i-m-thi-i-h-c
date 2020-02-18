package service;

import java.util.Comparator;
import java.util.List;

import dao.DetailInforDao;
import entities.Student;

public class DetailInforService {

	private DetailInforDao detailInforDao = null;
	public DetailInforService() {
		detailInforDao = new DetailInforDao();
	}
	public List<Student> getStuDetailInfor(String StrSearch,String target){
		return detailInforDao.getStuDetailInfor(StrSearch, target);
	}
	public void orderByListByID(List<Student> students){
		students.sort(Comparator.comparing(Student::getId));
	}
	public void orderByListByName(List<Student> students){
		students.sort(Comparator.comparing(Student::getName));
	}
	public void orderByListByDiemTong(List<Student> students){
		students.sort(Comparator.comparing(Student::getDiemTong).reversed());
	}
	
}
