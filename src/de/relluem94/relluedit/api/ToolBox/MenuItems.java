package de.relluem94.relluedit.api.ToolBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.charset.Charset;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import de.relluem94.relluedit.functions.Frames;

public class MenuItems extends Frames{


	



public void FileOpener() {
	try{
		JFileChooser chooser = new JFileChooser();
        // Dialog zum Oeffnen von Dateien anzeigen
        chooser.showOpenDialog(null);
        name = chooser.getSelectedFile().getName();
        File file = chooser.getSelectedFile();

        pfad = file.getPath();
		size = file.length() + " Bytes";
		
		statusbar_pfad.setText(pfad);
		statusbar_size.setText(size);
        
		Datei = file;
		content = Toolbox.readFile(file.getPath(), Charset.defaultCharset());
		textPane.setText(content);
	    frame.setTitle(title + " - [" + name + "]"); 
    }
    catch(NullPointerException es){
    	
    }
	
}


	public JMenuItem open(){
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_open"));
		meunItem.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e){
			 
			 try{
				 	FileOpener();
		        }
		        catch(NullPointerException es){
		        	
		        }
		    }
		});
		
		return meunItem;
	}
	 
	public JMenuItem neu(){
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_new"));
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        textPane.setText("");
		        frame.setTitle(title + " - [" + bundle.getString("l_unnamed") + "]"); 
		        
				statusbar_pfad.setText("");
				statusbar_size.setText("");
		    }
		});

		return meunItem;
	}
	
	
	public JMenuItem save(){
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_save"));
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	if(Datei != null){
					File file = Datei;
					
					content = textPane.getText();
					Toolbox.writeFile(file, content);
					  
					name = file.getName();
			        pfad = file.getPath();
					size = file.length() + " Bytes";
					
					statusbar_pfad.setText(pfad);
					statusbar_size.setText(size);
			        
			        frame.setTitle(title + " - [" + name + "]"); 

				}
		    	else{
					System.out.println("Error File == null");
				}
		    }
		});
		
		return meunItem;
	}
	
	public JMenuItem saveAs(){
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_saveas"));
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        
		        
		        try{
		        		JFileChooser chooser = new JFileChooser();
				        // Dialog zum Oeffnen von Dateien anzeigen
				        chooser.showSaveDialog(null);
				        
				        File file = chooser.getSelectedFile();
				        
				        
				        content = textPane.getText();
				        Toolbox.writeFile(file, content);
				        
				        name = file.getName();
				        pfad = file.getPath();
	    				size = file.length() + " Bytes";
	    				
	    				statusbar_pfad.setText(pfad);
	    				statusbar_size.setText(size);
	    				Datei = file;
				        frame.setTitle(title + " - [" + name + "]"); 
				        
		        }
		        catch(NullPointerException es){
		        	
		        }
		       
		        
		        
		    }
		});
		
		return meunItem;
	}
	
	public JMenuItem find(){
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_find"));
		meunItem.setMnemonic(KeyEvent.VK_F);
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	findFrame.setVisible(true);
		    }
		});
		
		return meunItem;
	}
	
	public JMenuItem replace(){	
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_replace"));
		meunItem.setMnemonic(KeyEvent.VK_R);
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	replaceFrame.setVisible(true);
		    }
		});
		
		return meunItem;
	}
	
	public JMenuItem replaceLine(){	
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_replaceline"));
		meunItem.setMnemonic(KeyEvent.VK_L);
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
//		    	Frames f = new Frames(main);
//		    	f.ReplaceLineFrame();
		    	
		    	replaceLineFrame.setVisible(true);
		    }
		});
		
		return meunItem;
	}
	
	public JMenuItem copy(){		
		meunItem = new JMenuItem();
		Action copyAction = new DefaultEditorKit.CopyAction();
	    copyAction.putValue(Action.NAME, bundle.getString("l_copy"));
	    meunItem.setAction(copyAction);
		return meunItem;
	}
	
	public JMenuItem paste(){	
		meunItem = new JMenuItem();
		Action pasteAction = new DefaultEditorKit.PasteAction();
		pasteAction.putValue(Action.NAME, bundle.getString("l_paste"));
		meunItem.setAction(pasteAction);
		return meunItem;
	}
	
	public JMenuItem cut(){		
		meunItem = new JMenuItem();
		Action cutAction = new DefaultEditorKit.CutAction();
		cutAction.putValue(Action.NAME, bundle.getString("l_cut"));
		meunItem.setAction(cutAction);
		return meunItem;
	}
	
	public JMenuItem undo(){	
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_undo")); 
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	  try {
	                   if (unma.canUndo()) {
	                	   unma.undo();
	                   }
	               } catch (CannotUndoException ev) {
	               }
		    }
		});
		
		return meunItem;
	}
	
	public JMenuItem redo(){
		meunItem = new JMenuItem();	
		meunItem.setText(bundle.getString("l_redo"));
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	 try {
	                   if (unma.canRedo()) {
	                       unma.redo();
	                   }
	               } catch (CannotRedoException ev) {
	               }
		    }
		});
		
		return meunItem;
	}
	
	public JMenuItem optionen(){
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_preferences")); 
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	preferencesFrame.setVisible(true);
		    }
		});
		
		return meunItem;
	}
	
	public JMenuItem console(){	
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_console")); 
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	consoleFrame.setVisible(true);
		    }
		});
		
		return meunItem;
	}
	
	public JMenuItem version(){		
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_version")); 
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	VersionFrame.setVisible(true);
		    }
		});
		
		return meunItem;
	}
	
	public JMenuItem relluem94(){		
		meunItem = new JMenuItem();
		meunItem.setText(bundle.getString("l_relluem94")); 
		meunItem.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	Relluem94Frame.setVisible(true);
		    }
		});
		
		return meunItem;
	}
	
}
