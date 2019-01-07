package MYTOOLS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRepository_URIOJ {

    public static void main(String[] args) throws IOException {
        int startPage = 1001,end = 2657;
        String filename;
        
        int i = startPage;
        while(i <= end){
            URL url = new URL("https://www.urionlinejudge.com.br/repository/UOJ_"+i+"_en.html");
            
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if(responseCode >= 400){
                connection.disconnect();
                System.out.println("change URL");
                url = new URL("https://www.urionlinejudge.com.br/repository/UOJ_"+i+".html");
                connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                responseCode = connection.getResponseCode();
                if(responseCode >= 400){
                    break;
                }
                System.out.println("OK");
            }
            filename = "UOJ_"+i+"_en";
            PrintWriter outputFile = new PrintWriter("D:\\apache-tomcat-8.0.36/webapps/repository/1/" + filename + ".html");
            InputStream is = connection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = null;

            while ((line = br.readLine()) != null) {
                outputFile.println(line);
            }
            br.close();
            outputFile.close();
            connection.disconnect();
            i++;
        }

    }
}
