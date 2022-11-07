package RepasoFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class File01 {
	
	/*
	 * OPERACIONES BÁSICAS CON FICHEROS DE CARACTERES
	 */

	public static void main(String[] args) {

		/* FILE: clase java que se encarga de manipular ficheros y directorios */

		// Constructor de la clase File

		/*
		 * File variableFichero= new File("ruta fichero");
		 * 
		 * Al crear el constructor, la variable variableFichero es un objeto con los
		 * datos del fichero que se encuentra en la ruta pasada por parámetro, si es que
		 * existe
		 */

		File f1 = new File("./src/RepasoFile/fp1.txt");// f1 objeto tipo File donde guardamos el archivo ya existente
														// fp1.txt es la ruta y tanbién es el nombre del fichero

		if (f1.exists()) {
			System.out.println("Nombre archivo: " + f1.getName());
			System.out.println("Ruta: " + f1.getPath());
			System.out.println("Ruta absoluta: " + f1.getAbsolutePath());
			System.out.println("Se puede escribir: " + f1.canWrite());
			System.out.println("Se puede leer: " + f1.canWrite());
			System.out.println("Tamaño: " + f1.length());
		}

		/*
		 * Con esto se cierra el fichero y la variable variableFichero pasará a ser nula
		 * (null).
		 * 
		 * Cuando se quiere dejar de usar el fichero, se debe cerrar el mismo, cortando
		 * el flujo de datos y liberando la variable
		 */

		// f1.close();

		try {
			lecturaFicheros();
			escrituraFicheros();
			borradoFicheros();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	// LECTURA FICHEROS

	/*
	 * Para poder realizar las operaciones de lectura y escritura de ficheros, Java
	 * establece lo que se conoce como un Stream de datos (flujo de datos). Es
	 * decir, crea una vía de comunicación entre programa y fichero que permite
	 * “moverse” por las distintas partes del fichero.
	 * 
	 */

	public static void lecturaFicheros() throws IOException {

		// Fichero que queremos leer

		File fichero = null;

		// Stream de lectura de datos de un fichero
		FileReader lectura = null;

		/*
		 * Buffer de lectura que permite guardar en un nivel intermedio entre este
		 * programa y el fichero más de un caracter, y cuando el buffer se llena lo
		 * envía a mi programa, esto hace que la lectura sea más eficiente, porque se
		 * carga antes de enviarlo, en el buffer.
		 */

		BufferedReader bufferLectura = null;

		try {
			fichero = new File(".\\src\\RepasoFile\\fp1.txt");
			lectura = new FileReader(fichero);

			bufferLectura = new BufferedReader(lectura);

			// Función de bufferedReader que devuelve la siguiente línea de texto si existe,
			// si no devuelve null

			String linea = bufferLectura.readLine(); // guardo la línea retornada por el método .readLine() en un String
														// que llamamos línea

			/*
			 * Para leer todo el fichero, utilizo un while en el que le indico que mientra
			 * que linea no devuleva null, que me imprima, lo que guardo en el string linea
			 */

			while (linea != null) {//Mientras que readLine sea distinto de nulo, es decir, haya texto
				System.out.println(linea); //imprime la línea
				linea = bufferLectura.readLine();//Sigo leyendo la siguiente línea
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { //contiene las sentencias que se van a ejecutar exista o no una excepción
			
					bufferLectura.close();// Cerramos el buffer
					lectura.close();//cerramos la lectura

		}
	}

	// ESCRITURA DE DATOS EN UN FICHERO

	public static void escrituraFicheros() throws IOException {
		// Represemnta el fichero en el que se quiere escribir
		File fichero = null;

		// Establece el stream de datos de escritura del fichero
		FileWriter escritura = null;

		// Crea un buffer a través del FileWriter, que permite
		// extender los métodos del FileWriter por otros similares
		// a los que tenemos en la salida de pantalla.
		// El constructor recibe el FileWriter como parámetro
		PrintWriter pw = null;
		try {
			fichero = new File(".\\src\\RepasoFile\\fp1.txt");

			// True para añadir texto, false para escribir texto desde cero
			escritura = new FileWriter(fichero, true);
			pw = new PrintWriter(escritura);
			for (int i = 0; i < 10; i++) {
				pw.println("Linea " + i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero) {//Si el fichero es distinto de nulo, es decir, no se ha cerrado
					pw.close();
					escritura.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// BORRAR UN FICHERO

	public static void borradoFicheros() throws IOException {
		File fichero = new File(".\\src\\RepasoFile\\fp2.txt"); 
		if (fichero.exists()) { 
			System.out.println("Nombre del archivo "+ fichero.getName()); 
			System.out.println("Ruta "+ fichero.getPath()); 
			System.out.println("Ruta absoluta "+ fichero.getAbsolutePath()); 
			System.out.println("Se puede escribir "+fichero.canRead()); 
			System.out.println("Se puede leer "+fichero.canWrite()); 
			System.out.println("Tamaño "+fichero.length()); 
			} 
		fichero.delete();
	}

}
