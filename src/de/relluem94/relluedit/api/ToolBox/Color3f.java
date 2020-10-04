package de.relluem94.relluedit.api.ToolBox;



public class Color3f {
	
	public static final Color3f BLACK = new Color3f(0.0F, 0.0F, 0.0F);
	public static final Color3f WHITE = new Color3f(1.0F, 1.0F, 1.0F);
	public static final Color3f BLUE = new Color3f(0.0F, 0.0F, 1.0F);
	public static final Color3f RED = new Color3f(1.0F, 0.0F, 0.0F);
	public static final Color3f GREEN = new Color3f(0.0F, 1.0F, 0.0F);
	public static final Color3f GRAY = new Color3f(0.5F, 0.5F, 0.5F);
	public static final Color3f LIGHT_GRAY = new Color3f(0.3F, 0.3F, 0.3F);
	public static final Color3f DEFAULT = WHITE;
	
	
	
	public Color3f(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	
	public float r;
	public float g;
	public float b;
	
	public Color3f getColor() {
		return this; 
	}
	
}
