public class encoder {
    static byte[] encode(byte[] input){
        int size=((input.length+2)/3)*4;
        byte[] output=new byte[size];
        int i=0,j=0;

        while(i< input.length){
            int remaning= input.length-i;

            int b0=input[i++]&0xFF;
            int b1=(remaning>1)?input[i++]&0xFF:0;
            int b2=(remaning>2)?input[i++]&0xFF:0;

            int combined=(b0<<16)|(b1<<8)|(b2);

            int c0=(combined>>18)&0x3F;
            int c1=(combined>>12)&0x3F;
            int c2=(combined>>6)&0x3F;
            int c3=(combined)&0x3F;

            output[j++]=(byte)Base64Table.table[c0];
            output[j++]=(byte)Base64Table.table[c1];

            if(remaning==1){
                output[j++]=61;
                output[j++]=61;
            }else if (remaning==2){
                output[j++]=(byte)Base64Table.table[c2];
                output[j++]=61;

            }else {
                output[j++]=(byte)Base64Table.table[c2];
                output[j++]=(byte)Base64Table.table[c3];
            }

        }
        return output;
    }
}