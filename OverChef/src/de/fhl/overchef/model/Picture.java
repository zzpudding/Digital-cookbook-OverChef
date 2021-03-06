package de.fhl.overchef.model;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
/**
 * This Class is used to save and process image, such as loading, storing and deleting image.
 * @author Zhengjiang Hu
 * @version 5.0
 */
public class Picture {
	int width;
	int length;
	String res = "/src/de/fhl/overchef/model/Pictures/";

	String pictureName = "default name";
	String root = "default";
	Image image=null;
	BufferedImage bufferImage = null;
	FileOutputStream imageOut;
	FileInputStream imageIn;
	File file;
	
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	/**
	 * construct a instance of Picture and read the image from file system onto the ImageIOstream
	 * @param path picture's path
	 */
	public Picture(String path) {
		try {
			imageIn = new FileInputStream(path);
			image = new Image(imageIn);
			imageIn.close();
			file = new File(path);
			this.pictureName = file.getName();
		} catch (Exception e) {
		}
	}
	/**
	 * Check if there is file with the same name in the file system
	 * @return true: no file with the same name; false: file with the same name already exists
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static boolean checkName(String path) throws FileNotFoundException, IOException {
		//create a file linked to the file chosen by user, if user does't choose a file, parameter path will be default value.
		File chosenFile = new File(path);
		File[] fileList = new File(System.getProperty("user.dir") + "/src/de/fhl/overchef/model/Pictures/").listFiles();
		for(File f:fileList) {
			System.out.println(f.getName());
			if(f.getName().equals(chosenFile.getName())) {		
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
		System.out.println(file.getName());
		System.out.println("Picture: " + root);

			File outputImage = new File(this.root = System.getProperty("user.dir") + res + file.getName());
			bufferImage = SwingFXUtils.fromFXImage(image, null);
			imageOut  = new FileOutputStream(outputImage);
			ImageIO.write(bufferImage, pictureName.substring(pictureName.lastIndexOf(".") + 1), imageOut);
			imageOut.close();
	}
	/**
	 * delete the picture saved at the specific directory
	 * @throws IOException 
	 */
	public void deletePicture() throws IOException {
		this.file = new File(this.root);
		Path deletePath = Paths.get(root);
		if (file.exists() && !file.getName().equals("OverChefDefaultPicture.jpg")) {
			try {
				Files.delete(deletePath);
			}catch(IOException e) {
				e.printStackTrace();
			}
			// when the user delete the picture, root should be change to a default path, otherwise program will have an exception after save the recipe
			if (!this.file.exists()) {
				this.root = System.getProperty("user.dir") + res + "OverChefDefaultPicture.jpg";
				pictureName = "OverChefDefaultPicture.jpg";
			}
		}else {
			Alert noFileAlert = new Alert(Alert.AlertType.INFORMATION);
			noFileAlert.setTitle("Reminder");
			noFileAlert.setHeaderText("No picture to delete");
			noFileAlert.showAndWait();
			System.out.println("From Picture: Deleting a file: No file to delete");
		}
	}
}
