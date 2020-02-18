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

public class ServerConnection {

	private Socket s = null;
	private DataInputStream din = null;
	private ObjectInputStream oin = null;
	private DataOutputStream dout = null;
	private ObjectOutputStream oos = null;

	public ServerConnection(Socket s) {

		this.s = s;
		try {
			dout = new DataOutputStream(s.getOutputStream());
			oos = new ObjectOutputStream(dout);
			din = new DataInputStream(s.getInputStream());
			oin = new ObjectInputStream(din);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Student> getData(Request request) {
		List<Student> students = new ArrayList<Student>();
		
		try {
			oos.writeObject(request);
			students = (List<Student>) oin.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	public List<Student> getData2_1(Request2 request) {
		List<Student> students = new ArrayList<Student>();
		try {
			
			oos.writeObject(request);
			students = (List<Student>) oin.readObject();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	public ChiTietKhoi getData2_2(Request2 request) {
		ChiTietKhoi chiTietKhoi = new ChiTietKhoi();
		try {
			
			oos.writeObject(request);
			chiTietKhoi = (ChiTietKhoi) oin.readObject();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chiTietKhoi;
	}
	public boolean hasConnect() {
		String response;
		try {
			response = din.readUTF();
			if(response.equals("Succesfully connect")) {
				return true;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public void closeClient() {
		
		try {
			dout.close();
			dout.close();
			din.close();
			oin.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
