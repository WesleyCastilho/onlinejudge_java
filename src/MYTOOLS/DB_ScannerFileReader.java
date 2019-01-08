package MYTOOLS;


import java.io.*;
import java.util.Scanner;

public class DB_ScannerFileReader {

    private String filePath;

    public DB_ScannerFileReader(String filePath) {
        this.filePath = filePath;
    }

    public Scanner build(Class caller) throws IOException {
        File file = new File(caller.getResource(filePath).getPath());
        InputStreamReader in = new InputStreamReader(new FileInputStream(file));
        return new Scanner(in);
    }

}
