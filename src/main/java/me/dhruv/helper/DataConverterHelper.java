package me.dhruv.helper;

import com.sun.javafx.binding.StringFormatter;
import static java.lang.Math.toIntExact;

/**
 * Created by dhruvkalaria on 4/30/18.
 */
public class DataConverterHelper {

    // Map to store 62 possible characters
    static char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    static int BASE = map.length;

    public static String idToShortURL(Long id) {

       StringBuilder sb = new StringBuilder();
        while (id > 0) {
            int num = toIntExact(id%BASE);
            sb.append(map[num]);
            id/=BASE;
        }

        return sb.reverse().toString();
    }

    public static Long shortURLtoId(String encodedString) {
        long id=0;
        for(int i=0;i<encodedString.length();i++) {

            if ('a' <= encodedString.charAt(i) && encodedString.charAt(i) <= 'z') {
                id = id*BASE + encodedString.charAt(i) -'a';
            } else if ('A' <= encodedString.charAt(i) && encodedString.charAt(i) <= 'Z') {
                id = id*BASE + encodedString.charAt(i) -'A' + 26;
            }else if ('0' <= encodedString.charAt(i) && encodedString.charAt(i) <= '9') {
                id = id*BASE + encodedString.charAt(i) -'0' + 52;
            }
        }
        return id;
    }
}
