package Model;

import java.io.IOException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		acount a=new acount(1234567892,1721633485,55.25854544);
//		acountDAO adao=new acountDAO(a);
//		adao.createAcountFile();
//		try {
//			adao.writeAcount();
//			adao.readAcount();
//			System.out.println(a.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		acountDAO adao1=new acountDAO();
		try {
			acount a1=adao1.findAcountFile(998646185);
			if (a1 != null) {
			    System.out.println(a1.toString());
			} else {
			    System.out.println("Cuenta no encontrada.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
