import java.nio.charset.StandardCharsets;

class Commandnotfoundexception extends Exception{
    public Commandnotfoundexception(String message){
        super(message);
    }
}
public class Main {

    public static void main(String[] args) {
        byte[] input_bytes=FileUtil.readfile(args[1]);

        if (args[0].equals("--encode")){
            System.out.println("Encoding the file");
            byte[] output_bytes=encoder.encode(input_bytes);
            FileUtil.writefile("out.b64",output_bytes);

        } else if (args[0].equals("--decode")) {
            System.out.println("Decoding the file");
        }
        else {
            try {
                throw new Commandnotfoundexception("No such command found");
            }catch (Commandnotfoundexception e){
                System.out.println(args[0]+" "+e);
            }
        }
    }
}