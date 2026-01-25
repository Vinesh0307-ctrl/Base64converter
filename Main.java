import java.nio.charset.StandardCharsets;

class Commandnotfoundexception extends Exception{
    public Commandnotfoundexception(String message){
        super(message);
    }
}
public class Main {

    public static void main(String[] args) {
        String content;
        content=FileUtil.readfile(args[1]);
        byte[] input_bytes=content.getBytes(StandardCharsets.UTF_8);

        if (args[0].equals("--encode")){
            System.out.println("Encoding the file");
            byte[] output_byte=encoder.encode(input_bytes);

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