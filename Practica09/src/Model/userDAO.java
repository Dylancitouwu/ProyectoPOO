package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lib_genericP65v0.files;

public class userDAO {
	private user u;
	private files f;
	public userDAO() {
		u=new user();
		loadFile();
	}
	public userDAO(user u) {
		this.u=u;
	}
	private void loadFile() {
		f=new files("src/nomina");
		f.create(0);
		f.setFile(new File(f.getFile().getPath(),"Userlogin.txt"));
		f.create(1);	
	}
	public List<user> read() throws IOException {
	    List<user> users = new ArrayList<>();
	    String fileContent = f.readerFile(); // Lee el contenido del archivo	    
	    System.out.println("Contenido del archivo: " + fileContent); // Verifica el contenido
	    if (fileContent == null || fileContent.isEmpty()) {
	        System.out.println("El archivo está vacío o no se pudo leer correctamente.");
	        return users;
	    }
	    for (String line : fileContent.split("\n")) {
	        System.out.println("Leyendo línea: " + line);  // Verifica cada línea
	        String[] fields = line.split(",", -1);  // -1 asegura que se divida en el número exacto de campos

	        // Imprimir la cantidad de campos para cada línea
	        System.out.println("Número de campos: " + fields.length);

	        // Verificar que haya exactamente 10 campos
	        if (fields.length == 2) {
	        	user t = new user();
	            t.setNameuser(fields[0]);
	            t.setPassword(fields[1]);	            
	            users.add(t);
	        } else {
	            // Si la línea no tiene 10 campos, muestra un mensaje de error
	            System.out.println("La línea no tiene el formato correcto. Campos: " + fields.length);
	        }
	    }
	    System.out.println("Cantidad de empleados leídos: " + users.size());
	    return users;
	}
	
}




