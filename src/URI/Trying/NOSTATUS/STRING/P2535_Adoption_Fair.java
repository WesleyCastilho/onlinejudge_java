package URI.Trying.NOSTATUS.STRING;

import java.io.*;

public class P2535_Adoption_Fair {

    public P2535_Adoption_Fair() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        newCase:
        while (n-- > 0) {
            String species = br.readLine();
            String breed = br.readLine();
            String name = br.readLine();
            br.readLine();
            if (species.equals("cachorro")) {
                String[] st = name.split("\\s+");
                int size = st.length;
                if (size == 1) {
                    continue newCase;
                }

                for (int i = 0; i < size; i++) {
                    for (char c : st[i].toCharArray()) {
                        if (c == breed.charAt(0)) {
                            count++;
                            continue newCase;
                        }
                    }
                }
            }

        }
        System.out.println(count);
    }

}
