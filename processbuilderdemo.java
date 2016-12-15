import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class processbuilderdemo{
	
	public boolean compilation() throws IOException,InterruptedException {
            
		String command[] = {"g++","/home/ajaykumar/main.cpp"};
		ProcessBuilder pbc = new ProcessBuilder(command);
		Process compile = pbc.start();
		int errcode = compile.waitFor();
                return (errcode != 0 ? false : true);	
	
        }
        
        
        public boolean execution() throws IOException,InterruptedException {
            return processinput.check();
                
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
        
        /*public static void main(String args[]) throws IOException, InterruptedException{
           System.out.println(new processbuilderdemo().compilation());
        }*/

}
