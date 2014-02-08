package sigler.rebelempiremc.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveUtil
{
	public static void saveObject(Object obj, String path){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			System.out.println("successfully created file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Object readObject(String path){
		Object obj = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			obj = ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
		
	}
}
