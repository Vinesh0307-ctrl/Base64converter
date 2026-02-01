public class Base64Table {
    static final char[] table= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    public static int chartoindex(char c){
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }else if (c >= 'a' && c <= 'z') {
            return (c - 'a') + 26; // a=26 ... z=51
        } else if (c >= '0' && c <= '9') {
            return (c - '0') + 52; // 0=52 ... 9=61 }
        } else if (c=='+') {
            return 62;

        }else{
            return 63;
        }
    }
}
