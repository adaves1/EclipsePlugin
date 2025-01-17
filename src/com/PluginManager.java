package com.adaves1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PluginManager {
    public void loadPlugin(String eclpFilePath) {
        File eclpFile = new File(eclpFilePath);
        
        if (!eclpFile.exists() || !eclpFile.getName().endsWith(".eclp")) {
            System.out.println("Invalid .eclp file.");
            return;
        }

        String javaFilePath = eclpFilePath.replace(".eclp", ".java");
        try {
            // Convert .eclp to .java
            Files.copy(eclpFile.toPath(), Paths.get(javaFilePath));
            System.out.println("Converted " + eclpFile.getName() + " to " + javaFilePath);

            // Compile and run the Java file
            PluginCompiler compiler = new PluginCompiler();
            compiler.compileAndRun(javaFilePath);
        } catch (IOException e) {
            System.out.println("Error processing the file: " + e.getMessage());
        }
    }
}
