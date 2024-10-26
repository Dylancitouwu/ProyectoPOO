package lib_genericP65_V0;

import java.io.File;
import java.io.IOException;

public class Testing {

	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
		
		generic<String, Integer> g1=new generic<>("Test1");
		generic<String, Integer> g2=new generic<>("Test2",10);
		generic<String, Integer> g3=new generic<>("Test3","Marca3",20);
		generic<String, Integer> g4=new generic<>("Test4","Marca4",30,40);
		generic<String, Integer> g5=new generic<>("Test5",10,14,15,20,15);
		
		System.out.println(g1.toString());
		System.out.println(g2.toString());
		System.out.println(g3.toString());
		System.out.println(g4.toString());
//		System.out.println(g5.getAttArray2()[3]);
		
		
		generic<Integer, Double> g0 = new generic<>(1, 10.25, 14.8, 19.8,8.56);

        // Llamar al método typesElements
//        System.out.println(g0.typesElements(g0));

	////////////////////////
	//TESTING 1
	
	files objFile1=new files("C:/testfiles");
	files objFile2=new files("blablabla");
	objFile1.create(0);
	objFile2.create(0);
	objFile1.setFile(new File(objFile1.getFile().getAbsolutePath(),"notas.doc"));
	objFile1.create(1);
	objFile2.setFile(new File("blablabla/logs.txt"));
	objFile2.create(1);
	
	try {
		objFile1.writerFile("Dylan puerquita",false);
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	if(objFile1.validateByER("1A458", "^[0-3][A-Z][0-9](3)$")) {
		System.out.println("Cadena Aceptada");
	}
	
	
	
	try {
		objFile2.writerFile(objFile2.SearchReplace(objFile2.readerFile(), "Prueba", "Test"), true);
	}catch (IOException e){
		e.printStackTrace();
	}
	
	objFile1.getFileChooser(null, ".txt");
	System.out.println(objFile1.readerFile());
	
	
	
	
	
	
	
	
	

	}
	

	
};