package lib_genericP65_V0;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class files {
/**
 * @author Carlos Pilatuña
 * @since 2024/10/23
 */
    private generic<String, File> dt_a;  // Referencia a la clase genérica<T, S>
    private boolean flag = false;        // Variable de estado

    // Constructor que inicializa con un path de archivo
    public files(String pathname) {
        dt_a = new generic<>(pathname, new File(pathname));
    }

    /**
     * Método para escribir información en un archivo
     * @param text Texto a escribir en el archivo
     * @param allow Permiso de sobreescritura (true para sobreescribir, false para agregar)
     * @return true si la operación fue exitosa
     * @throws IOException en caso de error al escribir
     */
    public boolean writerFile(String text, boolean allow) throws IOException {
        FileWriter archivo = new FileWriter(dt_a.getAttribute3().getAbsolutePath(), !allow);
        archivo.write(text + "\n");
        archivo.close();
        return true;
    }

    /**
     * Método para leer datos de un archivo
     * @return Contenido del archivo como String
     * @throws IOException en caso de error al leer
     */
    public String readerFile() throws IOException {
        dt_a.setAttribute2("");  // Limpiar contenido previo
        FileReader reader = new FileReader(dt_a.getAttribute3().getAbsolutePath());
        int caracteres;
        while ((caracteres = reader.read()) != -1) {
            dt_a.setAttribute2(dt_a.getAttribute2() + (char) caracteres);
        }
        reader.close();
        return dt_a.getAttribute2();
    }

    /**
     * Método para crear archivos o directorios
     * @param tipo 0 para crear un directorio, 1 para crear un archivo
     * @return true si la operación fue exitosa
     */
    public boolean create(int tipo) {
        switch (tipo) {
            case 0:  // Crear directorio
                if (!dt_a.getAttribute3().exists()) {
                    flag = dt_a.getAttribute3().mkdir();
                }
                break;
            case 1:  // Crear archivo
                if (!dt_a.getAttribute3().exists()) {
                    try {
                        flag = dt_a.getAttribute3().createNewFile();
                    } catch (IOException e) {
                        flag = false;
                    }
                }
                break;
            default:
                flag = false;
                break;
        }
        return flag;
    }

    /**
     * Método para validar una cadena con una expresión regular
     * @param text Cadena de texto
     * @param ER Expresión regular
     * @return true si cumple con el patrón
     */
    public static boolean validateByER(String text, String ER) {
        return text.matches(ER);
    }

    /**
     * Método para buscar y reemplazar una palabra en un texto
     * @param text Texto original
     * @param replace Palabra de reemplazo
     * @param SearchWord Palabra a buscar
     * @return Texto modificado
     */
    public static String SearchReplace(String text, String replace, String SearchWord) {
        Pattern patron = Pattern.compile(SearchWord);
        Matcher analisis = patron.matcher(text);
        return analisis.replaceAll(replace);
    }
    public List<String> findWords(String text,String ER) {
    	Pattern patron=Pattern.compile(ER);
    	dt_a.setAttArray1(text.split("(\s+|[,.;])"));
    	for(String word:dt_a.getAttArray1()) {
    	Matcher analisis=patron.matcher(word);
    	if(analisis.find()) {
    	dt_a.addElementsList2(analisis.group());
    					}
    				}
    	return dt_a.getAttList2();
    			}
    	public File getFile() {
    	return dt_a.getAttribute3();
    		}
    	public void setFile(File new_file) {
    	dt_a.setAttribute3(new_file);
    	}
    	/**
    	* Lista los archivos de un directorio
    	* @return
    	*/
    	public String[] listFiles() {
    	if(dt_a.getAttribute3().isDirectory()) {
    	return dt_a.getAttribute3().list();
    	}else {
    	return null;
    		}
    	}
    	/**
    	* Metodo para devolver un listado de archivos o de directorios
    	* @param tipo tipo==1 Retorna directorios, tipo==0 Retorna archivos
    	* @return String[]
    	*/
    	public List<String> listFilesoDirectory(int tipo) {
    	dt_a.setAttArray1(listFiles());
    	if(dt_a.getAttArray1().length>0) {
    	for(String file:dt_a.getAttArray1()) {
    	dt_a.setAttribute4(new File(dt_a.getAttribute3().getAbsolutePath()+"/"+file));
    	if(tipo==1) {
    	if(dt_a.getAttribute4().isDirectory()) {
    	dt_a.addElementsList2(file);
    					}
    	}else if(tipo==0){
    	if(dt_a.getAttribute4().isFile()) {
    	dt_a.addElementsList2(file);
    					}
    				}
    			}
    		}
    	return dt_a.getAttList2();
    	}
    	/**
    	* Metodo para obtener un archivo del usando FileChooser
    	* @param pn
    	* @param extension
    	* @return
    	*/
    	public boolean getFileChooser(JFrame pn, String extension) {
    	JFileChooser file=new JFileChooser();
    	file.setAcceptAllFileFilterUsed(false);
    	file.addChoosableFileFilter(
    	new FileNameExtensionFilter(extension+ "files", new String[]{extension}));
    	file.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	int flag=file.showOpenDialog(pn); //Abre la ventana para buscar el archivo si flag
    	if(flag==file.APPROVE_OPTION) {
    	setFile(new File(file.getSelectedFile().getAbsolutePath()));
    	return true;
    	}else {
    	return false;
    			}
    		}
    	}