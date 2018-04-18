import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class FilePathVerification{
  public static void main(String args[ ])throws IOException{
      ArrayList <String> Word = new ArrayList<>();
      ArrayList<String> Definition = new ArrayList<>();
      File file = new File("Output.txt");
      try(BufferedReader in = new BufferedReader(new FileReader("file.txt"))) {
        String line;
        while((line = in.readLine())!=null) {
        String[] pair = line.split("");
        Word.add(pair[0]);
        Definition.add(pair[1]);
        }
      }catch (FileNotFoundException e){
        System.out.println("Path is not valid " + e.getLocalizedMessage());
      }catch (IOException ex) {
        ex.printStackTrace();
      }
    }
}
