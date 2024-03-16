import java.util.Arrays;

public class Main extends Thread {
    public void run() {
        new Atm();
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
       /*String sum =" ";
       StringBuilder stringBuilder = new StringBuilder();
       String name = "hello";
       char[] a = new char[name.length()];
        char dep;

        int[] myA = {12,12,45};
        ;

       for (int i=0; i<name.length()-1;i++) {
            a[i] = name.charAt(i);
           // sum += dep;
           stringBuilder.append(a[i]);
        }

        System.out.println(stringBuilder.toString());*/


    }
}