package de.relluem94.relluedit.api.ressources;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Images {

	//TODO gangbar machen für den Plugin Pfad und intern für die rellu images
	
	public static ImageIcon getImageIcon(String path){
		return new ImageIcon(path);
	}
	
	public static Image getImage(String path){
		return new ImageIcon(path).getImage();
	}
	
}
