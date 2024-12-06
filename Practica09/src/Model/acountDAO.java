package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class acountDAO implements configurable {
	private acount acount;
	private static final String DIRECTORY_PATH = "acounts/";
	public acountDAO() {//constructor sin parametros
		super();
		acount=new acount();
		file.create(0);
		
	}

	public acountDAO(Model.acount acount) {//constructor con parametros
		super();
		this.acount = acount;
		file.create(0);
	}
	/**
	 * Metodo para crear los archivos en el directorio del path
	 * @return
	 */
	public boolean createAcountFile() {
		file.setFile(new File(path,acount.getNumberAcount()+".txt"));
		return file.create(1);
	}
	
	public boolean writeAcount() throws IOException {
		return file.writerFile(acount.toString(), false);
	}
	public acount readAcount() throws IOException {
	    String values = file.readerFile(); 
	    String[] field = values.split(";"); 
	    
	    if (field.length != 3) { 
	        throw new IOException("Archivo corrupto o datos incompletos: " + file.getFile().getName());
	    }
	    
	    acount.setNumberAcount(Long.parseLong(field[0])); 
	    acount.setDni(Long.parseLong(field[1]));          
	    acount.setMount(Double.parseDouble(field[2]));    
	    
	    return acount;
	}
	
	public acount findAcountFile(long numberAcount) throws IOException {
		file.setFile(new File(path));
		String []files=file.listFiles();
		for(String f:files) {
			if(f.equals(numberAcount+".txt")) {
				file.setFile(new File(path,f));
				return readAcount();
			}
		}
		return null;
	}
	
	public acount findAcountFileByDni(long dni) throws IOException {
	    file.setFile(new File(path)); 
	    String[] files = file.listFiles(); 
	    
	    for (String f : files) {
	        file.setFile(new File(path, f)); 
	        try {
	            acount account = readAcount(); 
	            if (account != null && account.getDni() == dni) { 
	                return account; 
	            }
	        } catch (Exception e) {
	            System.err.println("Error al leer el archivo: " + f); 
	        }
	    }
	    return null; 
	}
	public boolean depositToAcount(long accountNumber, double amount) throws IOException {
	    acount account = findAcountFile(accountNumber);
	    if (account != null) {
	        account.setMount(account.getMount() + amount);  // Aumentar el saldo
	        writeAcount();  // Guardar los cambios en el archivo
	        return true;
	    }
	    return false;
	}
	
	public void updateAcount(acount account) throws IOException {
        File folder = new File(DIRECTORY_PATH);
        String[] files = folder.list();

        // Si no hay archivos, retornar
        if (files == null) {
            return;
        }

        // Buscar el archivo de la cuenta y actualizarlo
        for (String fileName : files) {
            if (fileName.equals(account.getNumberAcount() + ".txt")) {
                File file = new File(DIRECTORY_PATH, fileName);
                writeAcount(file, account);
                return;
            }
        }

        // Si no se encuentra el archivo, crearlo y escribir los datos
        createAndWriteAcount(account);
    }
	private void createAndWriteAcount(acount account) throws IOException {
        File file = new File(DIRECTORY_PATH, account.getNumberAcount() + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(account.getNumberAcount() + "," + account.getDni() + "," + account.getMount());
            writer.newLine();
        }
    }
	private void writeAcount(File file, acount account) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(account.getNumberAcount() + "," + account.getDni() + "," + account.getMount());
            writer.newLine();
        }
    }
	public String[] listAcounts() {
		file.setFile(new File(path));
		return file.listFiles();
	}
	
}
