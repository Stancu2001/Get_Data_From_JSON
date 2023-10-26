package Stancu;

import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class Main {
   public static void main(String[] args) {
      JSONParser parser = new JSONParser();
      try {
         Object obj = parser.parse(new FileReader("F:/TEST/user_data.json"));
         JSONObject jsonObject = (JSONObject)obj;
         System.out.print(jsonObject.size());
         JSONObject subjects =((JSONObject)((JSONObject)jsonObject.get("Activity")).get("Share History"));
         JSONArray link = (JSONArray)subjects.get("ShareHistoryList");
         System.out.print(" "+subjects.size()+" "+link.size());
         Iterator iterator = link.iterator();
         FileOutputStream fstream = new FileOutputStream("F:/TEST/Nagarro.txt",true);

         //identify File to be write?????? 
         //BufferedWriter out = new BufferedWriter(fstream);
         while (iterator.hasNext()) {
        	 //fstream.write(10);
        	 JSONObject json = (JSONObject)iterator.next();
        	 fstream.write((json.get("Link")+"\n").getBytes());
            //System.out.println(json.get("Link"));
         }
         fstream.close();
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
}
