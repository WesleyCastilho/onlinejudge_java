package MYFUNCTION;

/**
 * @Author Teerapat Phokhonwong
 * @DATE: 11/12/2018
 * @Note:
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class FindPermutaion {

    static TreeSet<String> permutationList ;
    public static void main(String[] args) throws IOException {
        permutationList = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        System.out.println("[ ===== find By Bit Permutation ===== ]");
        long start = System.nanoTime();
        int max = (int) Math.pow(2, st.length());
        for (int i = 1; i < max; i++) {
            findByBitPermutation(i, st);
        }

        for(String s : permutationList){
            System.out.println(s);
        }
        long end = System.nanoTime();
        double seconds = (double)(end-start) / 1_000_000_000.0;
        System.out.println(seconds+" sec");


    }

    static void findByBitPermutation(int i, String s) {
        int index = s.length()-1;
        String sup = "";
        while (i > 0) {
            int a = i % 2;
            if(a==1){
                sup = s.charAt(index)+""+sup;
            }
            i /= 2;
            index--;
        }
        permutationList.add(sup);
    }

}
