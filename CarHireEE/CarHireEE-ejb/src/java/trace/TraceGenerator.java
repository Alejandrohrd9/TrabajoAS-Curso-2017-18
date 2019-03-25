package trace;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TraceGenerator {
    String url = "/Users/alejandrohd/Documents/Universidad/AS/P2Files/traza.txt";
    public void traceDoc(String trace) throws IOException{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(url,true))) {
            bw.write(trace);
            bw.newLine();
        }
    }
}
