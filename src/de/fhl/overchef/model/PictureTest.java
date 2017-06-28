package de.fhl.overchef.model;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javafx.scene.image.Image;

public class PictureTest {
	
	private static Picture picture;
	
	@Before
	public void setUp() throws Exception {
		picture = new Picture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\testpicture.PNG");
	}

	@Test
	public void testGetImage() {
		assertTrue(picture.getImage() != null);
	}

	@Test
	public void testSetImage() {
		picture.setImage(picture.getImage());
		assertTrue(picture.getImage() != null);
	}

	@Test
	public void testGetRoot() {
		assertEquals("default", picture.getRoot());
	}

	@Test
	public void testSetRoot() {
		picture.setRoot("Null");
		assertEquals("Null", picture.getRoot());
	}

	@Test
	public void testCheckName() throws FileNotFoundException, IOException {
		assertFalse(Picture.checkName(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG"));
		assertTrue(Picture.checkName(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\nonexist.PNG"));
	}

	@Test
	public void testWritePicture() throws IOException {
		picture.writePicture();
		assertTrue(picture.getRoot().equals(System.getProperty("user.dir") + "/src/de/fhl/overchef/model/Pictures/testpicture.PNG"));
	}

	@Test
	public void testDeletePicture() throws IOException {
		picture.writePicture();
		picture.deletePicture();
		assertTrue(picture.getRoot().equals(System.getProperty("user.dir") + "/src/de/fhl/overchef/model/Pictures/" + "OverChefDefaultPicture.jpg"));
		
	}

	@Ignore
	public void testDeletePicture(String path) {
		fail("Not yet implemented");
	}

}