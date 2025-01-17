package com.adaves1;

import java.io.File;
import java.io.IOException;

public class PluginCompiler {
    public void compileAndRun(String javaFilePath) {
        try {
            // Check if JDK is installed
            ProcessBuilder processBuilder = new ProcessBuilder("javac", javaFilePath);
            Process process = processBuilder.inheritIO().start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Compilation successful. Running the plugin...");
                String className = new File(javaFilePath).getName().replace(".java", "");
                Process runProcess = new ProcessBuilder("java", className).inheritIO().start();
                runProcess.waitFor();
            } else {
                System.out.println("Compilation failed. Please check your code.");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error during compilation or execution: " + e.getMessage());
        }
    }
}
