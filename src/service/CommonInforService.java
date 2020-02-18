package service;

import java.util.List;


import dao.CommonInforDao;
import entities.ChiTietKhoi;
import entities.KhoiThi;
import entities.Student;

public class CommonInforService {

	private CommonInforDao commonInforDao = null;
	public CommonInforService() {
		commonInforDao = new CommonInforDao();
	}
	
	public List<Student> getTop10Stu(int idKhoi){
		return commonInforDao.getTop10stu(idKhoi);
	}
	public List<KhoiThi> getKhoiList(){
		return commonInforDao.getKhoiList();
	}
	public KhoiThi getKhoiThi(int idKhoi) {
		return commonInforDao.getKhoiThi(idKhoi);
	}
	public ChiTietKhoi getDataKhoi(int idKhoi) {
		return commonInforDao.getDataKhoi(idKhoi);
	}
	public List<Student> getDataByOfSchool(String schoolName){
		return commonInforDao.getDataOfSchool(schoolName);
	}
	public KhoiThi getKhoiThi(String tenKhoi) {
		return commonInforDao.getKhoiThi(tenKhoi);
	}
}
