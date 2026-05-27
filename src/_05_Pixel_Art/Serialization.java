package _05_Pixel_Art;



import java.io.*;



/*
 * Serialization is the process of converting an object into a stream of bytes
 * to store the object or transmit it to memory, a database, or a file. With
 * serialization, we can save an object and all of its state to a file.
 *
 * In Java, serialization is done by implementing the Serializable interface. Any
 * class that implements the Serializable interface can be "saved", as long
 * as all of its member variables are also serializable.
 *
 * Challenge: Complete the MinecraftCreeper class so that the test passes 
 * by making it implement the Serializable interface.
 */
public class Serialization {
	private static final String DATA_FILE = "src/_05_Pixel_Art/saved.dat";
	
	/*
	 * One simple way to save a serializable object to a file is using a FileOutputStream
	 * and ObjectOutputStream.
	 */
	 static void save(PixelArtMaker data) {
		try (FileOutputStream fos = new FileOutputStream(new File(DATA_FILE)); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 static PixelArtMaker load() {
		try (FileInputStream fis = new FileInputStream(new File(DATA_FILE)); ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (PixelArtMaker) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
			return null;
		}
	}
}
