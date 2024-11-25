package OtherProjects.src.hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        // Using + operator
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Using + operator: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("Resulting string: " + s);

        // Using StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("Using StringBuffer: " + (System.currentTimeMillis() - start) + "ms");

        // Using StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb2.append(r.nextInt(2));
        }
        s = sb2.toString();
        System.out.println("Using StringBuilder: " + (System.currentTimeMillis() - start) + "ms");

        // Using char array
        r = new Random(123);
        start = System.currentTimeMillis();
        char[] charArray = new char[65536];
        for (int i = 0; i < 65536; i++) {
            charArray[i] = (char) ('0' + r.nextInt(2));
        }
        s = new String(charArray);
        System.out.println("Using char array: " + (System.currentTimeMillis() - start) + "ms");
    }
}