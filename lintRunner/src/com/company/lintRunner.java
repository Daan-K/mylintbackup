package com.company;

import java.io.File;
import java.util.ArrayList;


public class lintRunner {
    private JLinter jLinter;
    private HLinter hLinter;

    public lintRunner(){
        jLinter = new JLinter();
        hLinter = new HLinter();

    }

    public String[] runLint(String filePath) throws Exception {
        String s = extension(filePath);
        if (s.equals("hs")) {
            return hLinter.runLinter(filePath);
        } else if (s.equals("js")) {
            return jLinter.runLinter(filePath);
        }
        throw new Exception("Extension Not Supported");
    }

    public String[][] runLint(String[] filePaths) throws Exception {
        String[][] result = new String[filePaths.length][];
        for(int i = 0; i < filePaths.length; i++){
            result[i] = runLint(filePaths[i]);
        }
        return result;
    }

    public String extension(String fileName){
        String extension = "";
        StringBuilder SB = new StringBuilder();
        int location = fileName.length()-1;
        char[] fileNameChar = fileName.toCharArray();
        while(fileNameChar[location] != '.'){
            SB.append(fileNameChar[location]);
            location--;
        }
        return SB.reverse().toString();
    }

    public ArrayList<File> fileNames(String folderPath){
        File directory = new File(folderPath);
        ArrayList<File> files = new ArrayList<File>();

        File[] fList = directory.listFiles();
        if(fList!= null) {
            for (File file : fList) {
                if (file.isFile())
                    files.add(file);
                else if (file.isDirectory())
                    files.addAll(fileNames(file.getAbsolutePath()));
            }
        }
        return files;
    }
}
