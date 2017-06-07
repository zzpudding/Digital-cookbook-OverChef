package de.fhl.overchef.model;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

public class Picture {
	int width;
	int length;
	String name = "Kevin";
	String root = null;
	BufferedImage image=null;
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
	Picture(String root){
		try{
			 image = ImageIO.read(new File(root));			 
		}
		catch(Exception e){}
	}

	/**
	 * write the image file to the given directory
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writePicture() throws FileNotFoundException, IOException {
		ImageIO.write(image, "png", new FileImageOutputStream(new File("D:\\Kevin's Java\\" + name + ".png")));
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
