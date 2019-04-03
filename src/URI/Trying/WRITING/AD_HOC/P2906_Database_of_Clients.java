/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge:
 * @Categories:
 * @Problem:
 * @Link:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.WRITING.AD_HOC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class P2906_Database_of_Clients {

    private static HashMap<String, Set<String>> emailProvider = new HashMap<>();
    private static HashMap<String, Set<String>> emailProviderBlackList = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int uniqueUsers = 0;
        for (int i = 0; i < n; i++) {
            String[] email = br.readLine().split("@");
            String username = email[0].replaceAll("[.+]", "");
            String provider = email[1];
            Set<String> userList = emailProvider.get(provider);
            Set<String> blackList = emailProviderBlackList.get(provider);
            if (userList == null) {
                userList = new TreeSet<>();
                blackList = new TreeSet<>();
                uniqueUsers++;
                userList.add(username);
                emailProvider.put(provider, userList);
                emailProviderBlackList.put(provider, blackList);
                continue;
            }

            if (blackList.contains(username)) {
                continue;
            }


            if (userList.contains(username)) {
                userList.remove(username);
                blackList.add(username);
                uniqueUsers--;
            } else {
                userList.add(username);
                uniqueUsers++;
            }

            emailProvider.put(provider, userList);
            emailProviderBlackList.put(provider, blackList);
        }
        System.out.println(uniqueUsers);
    }

}