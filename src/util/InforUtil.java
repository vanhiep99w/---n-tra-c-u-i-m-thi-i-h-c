package util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import entities.Student;

public class InforUtil {

	private static Random rd = new Random();
	private static int id = 102160102 ;
	
	private static List<Integer> listCum= Arrays.asList(1000000,2000000,3000000,4000000,5000000);
	static List<String> address= Arrays.asList("Nam Định","Hà Nội","Hồ Chí Minh","Quảng Nam","Đà Nẵng"
			,"Quảng Ninh","Huế","Thanh Hóa","Tây Nguyên");
	static List<String> firsts = Arrays.asList("Trần","Nguyễn","Hoàng","Phạm","Phan","Đặng","Bùi","Đỗ","Hồ","Ngô","Dương");//11
	static List<String> seconds = Arrays.asList("Thị","Bá","Đình","Văn Nhị","Đình","Hiếu","Huy","Nhất","Ánh","Phước","Hoàng","Quyên","Ly","Duyên","Trang","Tuân"
			,"Tú","Tình","Khánh","Quốc","Hữu","Danh","Sơn");
	static String school = "THPT";
	static List<String> schoolName= Arrays.asList("Lương Thế Vinh","Hai Bà Trưng","Lê Hồng Phong","Nguyễn Trãi","Trần Quốc Toản","Lê Dinh","Ngô Gia Hào","Bùi Định"
			,"Ngọc Hồi","Ngô Thì Nhậm","Thạch Thất","Xuân Thanh");
	public static String getFullName() {
		return firsts.get(rd.nextInt(firsts.size()))+" "+seconds.get(rd.nextInt(seconds.size()))+" "+seconds.get(rd.nextInt(seconds.size()));
	}
	
	public static String getSchool(int i) {
		return school +" "+ schoolName.get(i);
		
	}
	public static String getDayOfBirth() {
		int ngay =  rd.nextInt(32);
		int thang = rd.nextInt(13);
		int nam = 1998;
		return ngay+"/"+ thang+"/"+ nam;
	}
	public static String getAddress() {
		return address.get(rd.nextInt(address.size()));
	}
	public static Student creatStudent() {
		return new Student();
	}
	public static float getDiem() {
		float min = 0;
		float max = 10;
		return  min + rd.nextFloat() * (max - min);
	}
	public static int getIDCum() {
		return listCum.get(rd.nextInt(listCum.size()));
	}
	public static int getIDKhoi(){
		return 100+rd.nextInt(5);
	}
}
