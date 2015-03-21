import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which directory should I scan?");
        String line = buffer.readLine();

        lintRunner lR = new lintRunner();
        ArrayList<File> fileNames = lR.fileNames(line);
        String[] fileStrings = new String[fileNames.size()];
        for(int i = 0; i < fileNames.size(); i++)
            fileStrings[i] = fileNames.get(i).toString();

        System.out.println("Results:");
        System.out.println("------------------");
        for(String[] s : lR.runLint(fileStrings))
            for(String t : s)
                if(t != "")
                    System.out.println(t);

    }
}
