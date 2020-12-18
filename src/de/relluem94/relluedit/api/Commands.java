package de.relluem94.relluedit.api;

public class Commands {

    public static void Output(String s) {
        System.out.println(s);
    }

    public static void CMDOutput(String command) {
        System.out.println(">" + command);
    }

    public static void CMDOutput(String[] command, String s) {
        System.out.println(">" + command);
        System.out.println(s);
    }

    public static void CMDOutput(String command, String s) {
        System.out.println(">" + command);
        System.out.println(s);
    }

    public static void ErrorOutput(String s) {
        System.err.println("Warning: " + s);
    }

}
