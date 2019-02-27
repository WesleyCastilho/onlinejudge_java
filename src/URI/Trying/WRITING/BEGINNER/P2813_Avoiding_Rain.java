package URI.Trying.WRITING.BEGINNER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2813_Avoiding_Rain {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0, home = 0, office = 0, homeStored = 0, officeStored = 0;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            String h = st[0];
            String o = st[1];
            switch (h) {
                case "chuva":
                    switch (o) {
                        case "sol":
                            if (homeStored > 0) {
                                homeStored--;
                            } else {
                                home++;
                                officeStored++;
                            }
                            break;
                        case "chuva":
                            if (homeStored > 0) {
                                homeStored--;
                            } else {
                                home++;
                                officeStored++;
                            }

                            if (officeStored > 0) {
                                officeStored--;
                            } else {
                                office++;
                                homeStored++;
                            }
                            break;
                    }
                    break;
                case "sol":
                    switch (o) {
                        case "sol":
                            continue;
                        case "chuva":
                            if (officeStored > 0) {
                                officeStored--;
                            } else {
                                office++;
                                homeStored++;
                            }
                            break;
                    }
                    break;
            }
        }


        System.out.println(home + " " + office);
    }

}
