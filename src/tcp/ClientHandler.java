package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import entities.ChiTietKhoi;
import entities.Request;
import entities.Request2;
import entities.Student;
import service.CommonInforService;
import service.DetailInforService;

public class ClientHandler extends Thread {

	private Socket s = null;
	private DataInputStream din = null;
	private ObjectInputStream ois = null;
	private DataOutputStream dout = null;
	private ObjectOutputStream oos = null;
	private DetailInforService detailInforService = null;
	private CommonInforService commonInforService = null;

	public ClientHandler(Socket s) {
		this.s = s;
		detailInforService = new DetailInforService();
		commonInforService = new CommonInforService();

	}

	@Override
	public void run() {

		try {
			dout = new DataOutputStream(s.getOutputStream());
			oos = new ObjectOutputStream(dout);
			din = new DataInputStream(s.getInputStream());
			ois = new ObjectInputStream(din);

			try {
				dout.writeUTF("Succesfully connect");
				dout.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}

			while (true) {
				try {
					Object object = ois.readObject();
					if (object instanceof Request) {
						Request request = (Request) object;
						List<Student> students = handlRequest(request);
						oos.writeObject(students);
					} else {
						Request2 request = (Request2) object;
						if(request.getKind().equals("TOP 10 ")) {
							List<Student> students = handlRequest2_1(request);
							oos.writeObject(students);
						}else {
							ChiTietKhoi chiTietKhoi = handlRequest2_2(request);
							oos.writeObject(chiTietKhoi);
						}
						
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				
			}

		} catch (IOException e) {
			try {
				dout.close();
				oos.close();
				din.close();
				ois.close();
				s.close();
			} catch (IOException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			}
		}
		finally {
			
			
		}

	}

	public List<Student> handlRequest(Request request) {
		List<Student> students = new ArrayList<Student>();
		if (request.getValue().matches("[\\d]+")) {
			students = detailInforService.getStuDetailInfor(request.getValue(), "student.idHS");
			getSortedData(request.getKindOfOrderBy(), students);

		} else {
			students = detailInforService.getStuDetailInfor(request.getValue(), "student.tenHS");
			getSortedData(request.getKindOfOrderBy(), students);
		}
		return students;
	}

	public List<Student> handlRequest2_1(Request2 request) {
				
		List<Student> students = new ArrayList<Student>();
		int idKhoi = commonInforService.getKhoiThi(request.getKhoi()).getIdKhoi();
		students = commonInforService.getTop10Stu(idKhoi);
		return students;
	}
	public ChiTietKhoi handlRequest2_2(Request2 request){
		ChiTietKhoi chiTietKhoi = new ChiTietKhoi();
		int idKhoi = commonInforService.getKhoiThi(request.getKhoi()).getIdKhoi();
		chiTietKhoi = commonInforService.getDataKhoi(idKhoi);
		return chiTietKhoi;
	}

	public void getSortedData(String kindOfOrderBy, List<Student> students) {
		// private String[] comboboxName = { "Mặc Định","SBD","Tên", "Điểm Tổng" };
		if ("Tên".equals(kindOfOrderBy)) {
			detailInforService.orderByListByName(students);
		}
		if ("SBD".equals(kindOfOrderBy)) {
			detailInforService.orderByListByID(students);
		}
		if ("Điểm Tổng".equals(kindOfOrderBy)) {
			detailInforService.orderByListByDiemTong(students);
		}
	}

}
