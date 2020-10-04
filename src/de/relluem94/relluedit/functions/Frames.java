package de.relluem94.relluedit.functions;

import java.awt.Dimension;

import javax.swing.JInternalFrame;

import de.relluem94.relluedit.api.ToolBox.InternalFrames;
import de.relluem94.relluedit.api.ToolBox.Variables;

public class Frames extends Variables{
	
	
	public JInternalFrame editorFrame = EditorFrame();
	public JInternalFrame replaceLineFrame = ReplaceLineFrame();
	public JInternalFrame replaceFrame = ReplaceFrame();
	public JInternalFrame findFrame = FindFrame();
	public JInternalFrame consoleFrame = ConsoleFrame();
	public JInternalFrame Relluem94Frame = Relluem94Frame();
	public JInternalFrame VersionFrame = VersionFrame();
	public static JInternalFrame WierdThingFrame = WierdThingFrame(); 
	public JInternalFrame preferencesFrame = PreferencesFrame();
	
	
	
	public void addFrameToList(JInternalFrame frame){
		iframelist.add(frame);
	}
	
	public void addFrames(){
		addFrameToList(WierdThingFrame);
		addFrameToList(preferencesFrame);
		addFrameToList(findFrame);
		addFrameToList(consoleFrame);
		addFrameToList(replaceLineFrame);
		addFrameToList(replaceFrame);
		addFrameToList(Relluem94Frame);
		addFrameToList(VersionFrame);
		addFrameToList(editorFrame);
	}
	

	public JInternalFrame ReplaceLineFrame(){
		
		String title = bundle.getString("l_replaceline");
		Dimension size = new Dimension(450, 250);

		boolean iconifiable = true;
		boolean resizable = false;
		boolean closable = true;
		boolean dispose = true;
		boolean snapper = true;
		
		InternalFrames iframe = new InternalFrames(title, size, size, size, size, iconifiable, resizable, closable, dispose, snapper);
		Panes pane = new Panes(this, iframe);

		return iframe.makeFrame(pane.getReplaceLine());
	}

	public JInternalFrame PreferencesFrame(){
	
		String title = bundle.getString("l_preferences");
		Dimension size = new Dimension(450, 190);

		boolean iconifiable = false;
		boolean resizable = false;
		boolean closable = true;
		boolean dispose = true;
		boolean snapper = true;
		
		InternalFrames iframe = new InternalFrames(title, size, size, size, size, iconifiable, resizable, closable, dispose, snapper);
		Panes pane = new Panes(this, iframe);

		return iframe.makeFrame(pane.getPreferences());
	}

	
	public JInternalFrame FindFrame() {
		
		String title = bundle.getString("l_find");
		Dimension size = new Dimension(450, 190);

		boolean iconifiable = true;
		boolean resizable = false;
		boolean closable = true;
		boolean dispose = true;
		boolean snapper = true;
		
		InternalFrames iframe = new InternalFrames(title, size, size, size, size, iconifiable, resizable, closable, dispose, snapper);
		Panes pane = new Panes(this, iframe);

		return iframe.makeFrame(pane.getFind());
	}


	public JInternalFrame ReplaceFrame(){
		
		String title = bundle.getString("l_replace");
		Dimension size = new Dimension(450, 190);

		boolean iconifiable = true;
		boolean resizable = false;
		boolean closable = true;
		boolean dispose = true;
		boolean snapper = true;
		
		InternalFrames iframe = new InternalFrames(title, size, size, size, size, iconifiable, resizable, closable, dispose, snapper);
		Panes pane = new Panes(this, iframe);

		return iframe.makeFrame(pane.getReplace());
	}
	
	public static JInternalFrame WierdThingFrame(){
		
		String title = bundle.getString("l_relluem94");
		Dimension size = new Dimension(501, 504);

		boolean iconifiable = false;
		boolean resizable = false;
		boolean closable = true;
		boolean dispose = true;
		boolean snapper = true;
		
		InternalFrames iframe = new InternalFrames(title, size, size, size, size, iconifiable, resizable, closable, dispose, snapper);
		
		return iframe.makeFrame(new CubePanel());		
	}
	
	public JInternalFrame VersionFrame(){

		String title = bundle.getString("l_version");
		Dimension size = new Dimension(450, 290);

		boolean iconifiable = false;
		boolean resizable = false;
		boolean closable = true;
		boolean dispose = true;
		boolean snapper = true;
		
		InternalFrames iframe = new InternalFrames(title, size, size, size, size, iconifiable, resizable, closable, dispose, snapper);
		Panes pane = new Panes(this, iframe);

		return iframe.makeFrame(pane.getVersion());
	}

	public JInternalFrame Relluem94Frame(){
		
		String title = bundle.getString("l_relluem94");
		Dimension size = new Dimension(450, 190);

		boolean iconifiable = false;
		boolean resizable = false;
		boolean closable = true;
		boolean dispose = true;
		boolean snapper = true;
		
		InternalFrames iframe = new InternalFrames(title, size, size, size, size, iconifiable, resizable, closable, dispose, snapper);
		Panes pane = new Panes(this, iframe);

		return iframe.makeFrame(pane.getRelluem94());
	}
	
	public JInternalFrame EditorFrame(){
		
		String title = bundle.getString("l_editor");
		Dimension maxSize = new Dimension(screenSize.width, screenSize.height - 135);
		Dimension minSize = new Dimension(360, 460);
		Dimension prefSize = new Dimension(WIDTH -500, HEIGHT -200);
		Dimension size = new Dimension(WIDTH -500, HEIGHT -200);

		boolean iconifiable = true;
		boolean resizable = true;
		boolean closable = false;
		boolean dispose = false;
		boolean snapper = true;
		
		InternalFrames iframe = new InternalFrames(title, minSize, maxSize, prefSize, size, iconifiable, resizable, closable, dispose, snapper);
		Panes pane = new Panes(this, iframe);

		return iframe.makeFrame(pane.getEditor());
	}

	
	public JInternalFrame ConsoleFrame()	{
		
		String title = bundle.getString("l_console");
		Dimension size = new Dimension(screenSize.width/2, screenSize.height/2);


		boolean iconifiable = true;
		boolean resizable = false;
		boolean closable = true;
		boolean dispose = true;
		boolean snapper = true;
		
		InternalFrames iframe = new InternalFrames(title, size, size, size, size, iconifiable, resizable, closable, dispose, snapper);
		Panes pane = new Panes(this, iframe);

		return iframe.makeFrame(pane.getConsole());		
	}
	
}
