
/**
 *
 * @author ajaykumar
 */


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class fileCheck {

   public static boolean Check() throws IOException{
       
       
        FileInputStream fin1 =  new FileInputStream("/home/ajaykumar/output.txt");
        BufferedReader myInput1 = new BufferedReader(new InputStreamReader(fin1));
        StringBuilder sb1 = new StringBuilder();
        String thisLine = null;
       
        while ((thisLine = myInput1.readLine()) != null) {  
             sb1.append(thisLine);
        }
        
        thisLine = null;
        FileInputStream fin2 =  new FileInputStream("/home/ajaykumar/mainoutput.txt");
        BufferedReader myInput2 = new BufferedReader(new InputStreamReader(fin2));
        StringBuilder sb2 = new StringBuilder();
        while ((thisLine = myInput2.readLine()) != null) {  
                sb2.append(thisLine);
        }
        
        String a = null , b = null;
        a = sb1.toString();
        b = sb2.toString();
        return a.equals(b);
  
   }
}
