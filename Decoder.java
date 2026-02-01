public class Decoder {
    static byte[] decode(byte[] input){
        int padding=0;
        int len=input.length;
        if (input[len-1]==61)padding++;
        if (input[len-2]==61)padding++;
        int size=((input.length)/4)*3-padding;
        byte[] output=new byte[size];
        int i=0,j=0;

        while(i+3< input.length){
            int c0=Base64Table.chartoindex((char)input[i++]);
            int c1=Base64Table.chartoindex((char)input[i++]);
            int c2=(input[i]==61)?0:Base64Table.chartoindex((char)input[i]);
            i+=1;
            int c3=(input[i]==61)?0:Base64Table.chartoindex((char)input[i]);
            i+=1;

            int combined=(c0<<18)|(c1<<12)|(c2<<6)|(c3);
            int b0=(combined>>16)&0xFF;
            int b1=(combined>>8)&0xFF;
            int b2=(combined)&0xFF;

            if (j<size) output[j++]=(byte)b0;
            if (j<size) output[j++]=(byte)b1;
            if (j<size) output[j++]=(byte)b2;

        }
        return output;
    }
}
