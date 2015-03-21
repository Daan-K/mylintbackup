import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Linter{

    private String lintType;
    private String noSuggestionsMessage;

    public Linter(String lintType, String noSuggestionsMessage){

        this.lintType = lintType;
        this.noSuggestionsMessage = noSuggestionsMessage;
    }

    public String[] runLinter(String filePath) throws IOException {
        Process process = new ProcessBuilder(executionString(filePath)).start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        ArrayList<String> output = new ArrayList<String>();
        while((line = br.readLine()) != null)
            output.add(line);
        String[] out = output.toArray(new String[output.size()]);
        if(out[0].equals(noSuggestionsMessage))
            return new String[]{""};
        return out;
    }

    public String[] executionString(String filePath){
        return new String[]{lintType,filePath};
    }


}
