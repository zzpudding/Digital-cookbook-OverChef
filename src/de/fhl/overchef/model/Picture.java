package de.fhl.overchef.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;
/**
 * This Class is used to save and process image, such as loading, storing and deleting image.
 * @author HU
 * @version 2.0
 */
public class Picture {
	int width;
	int length;
	String root = "default";
	Image image=null;
	FileOutputStream imageOut;
	File file;
	
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	/**
	 * construct a instance of Picture and read the image from file system onto the ImageIOstream
	 * @param root
	 */
	public Picture(String path){
		try{
			 image = new Image(new FileInputStream(path));		
			 file = new File(path);
		}
		catch(Exception e){}
	}
	/**
	 * Check if there is file with the same name in the file system
	 * @return true: no file with the same name; false: file with the same name already exists
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean checkName() throws FileNotFoundException, IOException {
		File[] fileList = new File(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\").listFiles();
		for(File f:fileList) {
			System.out.println(f.getName());
			if(f.getName().equals(file.getName())) {		
				System.out.println("Same image name in current directory");
				return false;
			}
		}	
		return true;
	}
	/**
	 * write the image file to the given directory
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writePicture() throws IOException {
		imageOut = new FileOutputStream(this.root = System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\" + file.getName());
		imageOut.write(Files.readAllBytes(Paths.get(this.root)));	
		imageOut.close();
	}
	/**
	 * delete the picture
	 */
	public void deletePicture() {
		this.file = new File(this.root);
		this.file.delete();
	}
	
	public void deletePicture(String path) {
		this.file = new File(path);
		this.file.delete();
	}
}
