package de.relluem94.relluedit.functions;

import java.awt.Dimension;

import javax.swing.JInternalFrame;

import de.relluem94.relluedit.api.toolbox.InternalFrames;
import de.relluem94.relluedit.api.toolbox.Variables;

public class Frames extends Variables {

    public JInternalFrame editorFrame = editorFrame();
    public JInternalFrame replaceLineFrame = replaceLineFrame();
    public JInternalFrame replaceFrame = replaceFrame();
    public JInternalFrame findFrame = findFrame();
    public JInternalFrame consoleFrame = consoleFrame();
    public JInternalFrame relluem94Frame = relluem94Frame();
    public JInternalFrame versionFrame = versionFrame();
    public static JInternalFrame weirdThingFrame = weirdThingFrame();
    public JInternalFrame preferencesFrame = preferencesFrame();

    public void addFrameToList(JInternalFrame frame) {
        iframelist.add(frame);
    }

    public void addFrames() {
        addFrameToList(weirdThingFrame);
        addFrameToList(preferencesFrame);
        addFrameToList(findFrame);
        addFrameToList(consoleFrame);
        addFrameToList(replaceLineFrame);
        addFrameToList(replaceFrame);
        addFrameToList(relluem94Frame);
        addFrameToList(versionFrame);
        addFrameToList(editorFrame);
    }

    public JInternalFrame replaceLineFrame() {

        String replaceLineFrameTitle = bundle.getString("l_replaceline");
        Dimension replaceLineFrameSize = new Dimension(450, 250);

        boolean iconifiable = true;
        boolean resizable = false;
        boolean closable = true;
        boolean dispose = true;
        boolean snapper = true;

        InternalFrames iframe = new InternalFrames(replaceLineFrameTitle, replaceLineFrameSize, replaceLineFrameSize, replaceLineFrameSize, replaceLineFrameSize, iconifiable, resizable, closable, dispose, snapper);
        Panes pane = new Panes(this, iframe);

        return iframe.makeFrame(pane.getReplaceLine());
    }

    public JInternalFrame preferencesFrame() {

        String preferencesFrameTitle = bundle.getString("l_preferences");
        Dimension preferencesFrameSize = new Dimension(450, 190);

        boolean iconifiable = false;
        boolean resizable = false;
        boolean closable = true;
        boolean dispose = true;
        boolean snapper = true;

        InternalFrames iframe = new InternalFrames(preferencesFrameTitle, preferencesFrameSize, preferencesFrameSize, preferencesFrameSize, preferencesFrameSize, iconifiable, resizable, closable, dispose, snapper);
        Panes pane = new Panes(this, iframe);

        return iframe.makeFrame(pane.getPreferences());
    }

    public JInternalFrame findFrame() {

        String findFrameTitle = bundle.getString("l_find");
        Dimension findFrameSize = new Dimension(450, 190);

        boolean iconifiable = true;
        boolean resizable = false;
        boolean closable = true;
        boolean dispose = true;
        boolean snapper = true;

        InternalFrames iframe = new InternalFrames(findFrameTitle, findFrameSize, findFrameSize, findFrameSize, findFrameSize, iconifiable, resizable, closable, dispose, snapper);
        Panes pane = new Panes(this, iframe);

        return iframe.makeFrame(pane.getFind());
    }

    public JInternalFrame replaceFrame() {

        String replaceFrameTitle = bundle.getString("l_replace");
        Dimension replaceFrameSize = new Dimension(450, 190);

        boolean iconifiable = true;
        boolean resizable = false;
        boolean closable = true;
        boolean dispose = true;
        boolean snapper = true;

        InternalFrames iframe = new InternalFrames(replaceFrameTitle, replaceFrameSize, replaceFrameSize, replaceFrameSize, replaceFrameSize, iconifiable, resizable, closable, dispose, snapper);
        Panes pane = new Panes(this, iframe);

        return iframe.makeFrame(pane.getReplace());
    }

    public static JInternalFrame weirdThingFrame() {

        String weirdThingFrameTitle = bundle.getString("l_relluem94");
        Dimension weirdThingFrameSize = new Dimension(501, 504);

        boolean iconifiable = false;
        boolean resizable = false;
        boolean closable = true;
        boolean dispose = true;
        boolean snapper = true;

        InternalFrames iframe = new InternalFrames(weirdThingFrameTitle, weirdThingFrameSize, weirdThingFrameSize, weirdThingFrameSize, weirdThingFrameSize, iconifiable, resizable, closable, dispose, snapper);

        return iframe.makeFrame(new CubePanel());
    }

    public JInternalFrame versionFrame() {

        String versionFrameTitle = bundle.getString("l_version");
        Dimension versionFrameSize = new Dimension(450, 290);

        boolean iconifiable = false;
        boolean resizable = false;
        boolean closable = true;
        boolean dispose = true;
        boolean snapper = true;

        InternalFrames iframe = new InternalFrames(versionFrameTitle, versionFrameSize, versionFrameSize, versionFrameSize, versionFrameSize, iconifiable, resizable, closable, dispose, snapper);
        Panes pane = new Panes(this, iframe);

        return iframe.makeFrame(pane.getVersion());
    }

    public JInternalFrame relluem94Frame() {

        String relluem94FrameTitle = bundle.getString("l_relluem94");
        Dimension relluem94FrameSize = new Dimension(450, 190);

        boolean iconifiable = false;
        boolean resizable = false;
        boolean closable = true;
        boolean dispose = true;
        boolean snapper = true;

        InternalFrames iframe = new InternalFrames(relluem94FrameTitle, relluem94FrameSize, relluem94FrameSize, relluem94FrameSize, relluem94FrameSize, iconifiable, resizable, closable, dispose, snapper);
        Panes pane = new Panes(this, iframe);

        return iframe.makeFrame(pane.getRelluem94());
    }

    public JInternalFrame editorFrame() {

        String editorFrameTitle = bundle.getString("l_editor");
        Dimension maxSize = new Dimension(screenSize.width, screenSize.height - 135);
        Dimension minSize = new Dimension(360, 460);
        Dimension prefSize = new Dimension(WIDTH - 500, HEIGHT - 200);
        Dimension editorFrameSize = new Dimension(WIDTH - 500, HEIGHT - 200);

        boolean iconifiable = true;
        boolean resizable = true;
        boolean closable = false;
        boolean dispose = false;
        boolean snapper = true;

        InternalFrames iframe = new InternalFrames(editorFrameTitle, minSize, maxSize, prefSize, editorFrameSize, iconifiable, resizable, closable, dispose, snapper);
        Panes pane = new Panes(this, iframe);

        return iframe.makeFrame(pane.getEditor());
    }

    public JInternalFrame consoleFrame() {

        String consoleFrameTitle = bundle.getString("l_console");
        Dimension consoleFrameSize = new Dimension(screenSize.width / 2, screenSize.height / 2);

        boolean iconifiable = true;
        boolean resizable = false;
        boolean closable = true;
        boolean dispose = true;
        boolean snapper = true;

        InternalFrames iframe = new InternalFrames(consoleFrameTitle, consoleFrameSize, consoleFrameSize, consoleFrameSize, consoleFrameSize, iconifiable, resizable, closable, dispose, snapper);
        Panes pane = new Panes(this, iframe);

        return iframe.makeFrame(pane.getConsole());
    }

}
