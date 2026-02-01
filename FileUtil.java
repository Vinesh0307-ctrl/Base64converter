

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtil {
  static byte[] readfile(String path){
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
        String con=content.toString();
      byte[] output = con.getBytes(StandardCharsets.UTF_8);
      return output;
    }
  static void writefile(String filename,byte[] data){
      try {
          FileOutputStream fos=new FileOutputStream(filename);
          fos.write(data);
          fos.close();
          System.out.println("Successfully converted the file ");
      }
      catch (IOException e){
          System.out.println("Cannot write into the file: "+e);
      }

  }
}
