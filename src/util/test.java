package util;



import dao.CommonInforDao;

public class test {

	public static void main(String[] args) {

		CommonInforDao con = new CommonInforDao();
		int id = 102160100;
		int count = 1;
		int x = 0;
		for (int i = 0; i < 200; i++) {
			count++;
			if (count <= 20) {
				con.inserDataIntoStudent(x, ++id);
				con.inserDataIntoDiem(id);
			} else {
				x++;
				count = 1;
			}

		}

		
	}
}
