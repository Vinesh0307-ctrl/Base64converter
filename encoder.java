
public class encoder {
    static byte[] encode(byte[] input){
        int outputsize=((input.length+2)/3)*4;
        byte[] output=new byte[outputsize];
        int i=0,j=0;

        while(i<input.length){
            int b0=input[i++]&0xFF;
            int b1=(i< input.length)?input[i++] & 0xFF:0;
            int b2=(i< input.length)?input[i++] & 0xFF:0;

            int combined=(b0<<16)|(b1<<8)|(b2);

            int c0=(combined>>18) & 0x3F;
            int c1=(combined>>12) & 0x3F;
            int c2=(combined>>6) & 0x3F;
            int c3=(combined) & 0x3F;

            output[j++]=(byte) Base64Table.table[c0];
            output[j++]=(byte) Base64Table.table[c1];

            if(i-1>input.length){
                output[j++]= 61;
                output[j++]=61;
            } else if (i<input.length) {
                output[j++]=(byte)Base64Table.table[c2];
                output[j++]=61;
            }
            else{
                output[j++]=(byte)Base64Table.table[c2];
                output[j++]=(byte)Base64Table.table[c3];
            }
        }



        return output;
    }
}
