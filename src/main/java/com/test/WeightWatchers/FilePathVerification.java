package com.test.WeightWatchers;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class FilePathVerification{
  public static void main(String args[ ])throws IOException{
      ArrayList <String> Word = new ArrayList<String>();
      ArrayList<String> Definition = new ArrayList<String>();
      File file = new File("Output.txt");
      try{
    	  System.out.println(System.getProperty("user.dir"));
    	  	BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/java/com/test/WeightWatchers/file.txt"));
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
/*
/Users/Shravya/eclipse-workspace/WeightWatchers/com/test/WeightWatchers/file.txt
/Users/Shravya/eclipse-workspace/WeightWatchers/src/main/java/com/test/WeightWatchers/file.txt

*/