
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class writeFile1{
    public static void write(String[] args) throws IOException {
            File fout = new File("/home/ajaykumar/main.cpp");
            FileOutputStream fos = new FileOutputStream(fout);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
                for (String arg : args) {
                    String t;
                    t = arg;
                    bw.write(t);
                    bw.newLine();
                }
        }
    }
}


