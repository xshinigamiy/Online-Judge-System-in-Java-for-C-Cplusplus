
/**
 *
 * @author ajaykumar
 */


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;


public class processinput {
    
    public static boolean check() throws IOException, InterruptedException{

        //String command[] = {"g++","/home/ajaykumar/main.cpp"};	
        //ProcessBuilder pbc = new ProcessBuilder(command);	
        //Process compile = pbc.start();
	//int errcode = compile.waitFor();			
        //System.out.println("Compilation " + (errcode != 0 ? "Error" : "Successful"));
        
        
        
        
        ProcessBuilder pb2 = new ProcessBuilder("/home/ajaykumar/NetBeansProjects/jdbcdemo/./a.out");
        Process execute;
        
        FileInputStream fin = new FileInputStream("/home/ajaykumar/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fin)); 
        StringBuilder sb = new StringBuilder("");
        
        String line = br.readLine();
        
        sb.append(line).append("\n");
        
        while((line = br.readLine()) != null){
            sb.append(line).append("\n");
        }
        
        line = sb.toString();
        
        
        String[] str = line.split("\\n");
        
        String outputString = "";
        
        for (String str1 : str) {
            execute = pb2.start();
            OutputStream os = execute.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println(str1);
            ps.flush();
            execute.waitFor();
            outputString += output(execute.getInputStream());
        }
        
        
        System.setOut(new PrintStream(new FileOutputStream("/home/ajaykumar/mainoutput.txt")));
        System.out.println(outputString);
        System.setOut(System.out);
        
        return fileCheck.Check();
          
    }
    
    
    private static String output(InputStream is) throws IOException {
		StringBuilder sb = null;
		BufferedReader br = null;
		try {
			String line = null ;
			sb = new StringBuilder();
			br = new BufferedReader(new InputStreamReader(is));
			while((line = br.readLine()) != null){
				sb.append(line).append("\n");
			}
		
		}finally {
		
			br.close();
		
		}
		return sb.toString();
	}
}
