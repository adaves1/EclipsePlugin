package com.yourname;

import java.io.File;

public class EclipsePluginLoader {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the path to the .eclp file.");
            return;
        }

        String eclpFilePath = args[0];
        PluginManager pluginManager = new PluginManager();
        pluginManager.loadPlugin(eclpFilePath);
    }
}
