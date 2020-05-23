package MYTOOLS;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;

public class DB_BufferedFileReader {

    private String filePath;

    public DB_BufferedFileReader(String filePath) {
        this.filePath = filePath;
    }

    public BufferedReader build(Class caller) throws IOException {
        File file = new File(caller.getResource(filePath).getPath());
        InputStreamReader in = new InputStreamReader(new FileInputStream(file));
        return new BufferedReader(in);
    }

}
