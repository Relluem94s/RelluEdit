package de.relluem94.relluedit.api;

public class PluginCommand {

    private CommandExecutor executor;

    protected PluginCommand(String name, Plugin owner) {
        super();
    }

    public void setExecutor(CommandExecutor executor) {
        this.executor = executor;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

}
