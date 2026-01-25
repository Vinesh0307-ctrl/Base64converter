

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtil {
  static String readfile(String path){
      StringBuilder content=new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),StandardCharsets.UTF_8));
            String Line;
            while((Line=reader.readLine())!=null){
                content.append(Line).append('\n');
            }

            reader.close();
        }catch (IOException e){
            System.out.println("Cannot find the file. Try giving the full path"+e);
        }
        return content.toString();
    }
  static String writefile(String content){
      BufferedWriter writer=new BufferedWriter(new FileWriter("Output.b64"));


  }
}
