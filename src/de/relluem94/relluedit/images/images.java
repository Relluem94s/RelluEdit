package de.relluem94.relluedit.images;

import java.awt.Image;

import javax.swing.ImageIcon;

public class images {

	
	public static ImageIcon getImageIcon(String path){
		return new ImageIcon(images.class.getResource(path));
	}
	
	public static Image getImage(String path){
		return new ImageIcon(images.class.getResource(path)).getImage();
	}
	
}
