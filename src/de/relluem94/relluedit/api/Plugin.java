package de.relluem94.relluedit.api;

import java.io.File;

public abstract interface Plugin{
	
public abstract File getDataFolder();

public abstract boolean isEnabled();

public abstract void onDisable();

public abstract void onLoad();

public abstract void onEnable();

public abstract String getName();
}
