import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teerapat_
 */
public class GetCountingProblem {

    static final List<OJSource> sourceList = new ArrayList<>();
    static OJSource AIZU = new OJSource();
    static OJSource CODECHEF = new OJSource();
    static OJSource COJ = new OJSource();
    static OJSource TOPCODER = new OJSource();
    static OJSource URI = new OJSource();
    static OJSource UVA = new OJSource();
    static OJSource ZOJ = new OJSource();
    static OJSource SPOJ = new OJSource();
    static OJSource DEVSKILL = new OJSource();
    static OJSource CODERBYTE = new OJSource();
    static OJSource HACKERRANK = new OJSource();
    static OJSource HACKEREARTH = new OJSource();
    static OJSource CODINGAME = new OJSource();
    static OJSource CODEFORCES = new OJSource();
    static OJSource GOOGLE_CODEJAM = new OJSource();

    static {
        AIZU.setName("AIZU");
        AIZU.setLink("http://judge.u-aizu.ac.jp/onlinejudge/");
        AIZU.setProfile("http://judge.u-aizu.ac.jp/onlinejudge/user.jsp?id=teerapat_");

        CODECHEF.setName("CODECHEF");
        CODECHEF.setLink("https://www.codechef.com/");
        CODECHEF.setProfile("https://www.codechef.com/users/teerapat_");

        COJ.setName("COJ");
        COJ.setLink("http://coj.uci.cu/index.xhtml");
        COJ.setProfile("");

        TOPCODER.setName("TOPCODER");
        TOPCODER.setLink("https://www.topcoder.com/");
        TOPCODER.setProfile("");

        URI.setName("URI");
        URI.setLink("https://www.urionlinejudge.com.br/judge/en");
        URI.setProfile("https://www.urionlinejudge.com.br/judge/en/profile/56315");

        UVA.setName("UVA");
        UVA.setLink("https://uva.onlinejudge.org/");
        UVA.setProfile("UserName:boombarm | Online Judge ID: 752084");

        ZOJ.setName("ZOJ");
        ZOJ.setLink("http://acm.zju.edu.cn/onlinejudge/");
        ZOJ.setProfile("");

        SPOJ.setName("SPOJ");
        SPOJ.setLink("http://acm.zju.edu.cn/onlinejudge/");
        SPOJ.setProfile("");

        DEVSKILL.setName("DEVSKILL");
        DEVSKILL.setLink("https://www.devskill.com/Home");
        DEVSKILL.setProfile("");

        CODERBYTE.setName("CODERBYTE");
        CODERBYTE.setLink("");
        CODERBYTE.setProfile("");

        HACKERRANK.setName("HACKERRANK");
        HACKERRANK.setLink("https://www.hackerrank.com");
        HACKERRANK.setProfile("https://www.hackerrank.com/BOOM_BOOM");

        HACKEREARTH.setName("HACKEREARTH");
        HACKEREARTH.setLink("https://www.hackerearth.com/");
        HACKEREARTH.setProfile("");

        CODINGAME.setName("CODINGAME");
        CODINGAME.setLink("https://www.codingame.com");
        CODINGAME.setProfile("https://www.codingame.com/profile/03109d019ae7e4f9d70c1a1f068685ca6501942");

        //add 10-01-2018
        CODEFORCES.setName("CODEFORCES");
        CODEFORCES.setLink("http://codeforces.com/");
        CODEFORCES.setProfile("http://codeforces.com/profile/teerapat_");

        //add 24-12-2018
        GOOGLE_CODEJAM.setName("GOOGLE_CODEJAM");
        GOOGLE_CODEJAM.setLink("https://codingcompetitions.withgoogle.com/codejam/archive");
        GOOGLE_CODEJAM.setProfile("");

        sourceList.add(AIZU);
        sourceList.add(CODECHEF);
        sourceList.add(COJ);
        sourceList.add(TOPCODER);
        sourceList.add(URI);
        sourceList.add(UVA);
        sourceList.add(ZOJ);
        sourceList.add(SPOJ);
        sourceList.add(DEVSKILL);
        sourceList.add(CODERBYTE);
        sourceList.add(HACKERRANK);
        sourceList.add(HACKEREARTH);
        sourceList.add(CODINGAME);
        sourceList.add(CODEFORCES);
        sourceList.add(GOOGLE_CODEJAM);
    }


    static final String ROOT_DIRECTORY = "src";
    static final String NOTE_FILE = "NOTE.txt";
    static final String MAP_FILE = "MAP.txt";


    static int totalJavaFile = 0;
    static int totalAcceptedFile = 0;
    static BufferedWriter bw_MapAll;
    static BufferedWriter bw_Map;
    static BufferedWriter bw_Note;
    static int[] levelSpeceSize;
    static String source;

    public static void main(String[] a) throws IOException {

        File root = new File(ROOT_DIRECTORY);
        bw_MapAll = new BufferedWriter(new FileWriter(MAP_FILE));
        bw_MapAll.append(new String(new char[100]) + "\n");
        bw_MapAll.newLine();
        bw_MapAll.newLine();
        bw_MapAll.append("src -|\n");
        // get all the files from a directory
        File[] fList = root.listFiles();

        for (File file : fList) {
            if (file.isDirectory()) {
                String directoryName = file.getName();
                String ojDir = ROOT_DIRECTORY + "/" + directoryName;
                String ojMapFile = ojDir + "/" + MAP_FILE;
                String ojNoteFile = ojDir + "/" + NOTE_FILE;
                bw_Map = new BufferedWriter(new FileWriter(ojMapFile));
                bw_Map.append(new String(new char[100]) + "\n");//Set Head space
                bw_Map.append(new String(new char[100]) + "\n");//Set Head space

                bw_Note = new BufferedWriter(new FileWriter(ojNoteFile));
                String[] pair = getWebsite(directoryName);
                bw_Note.append("Website: " + pair[0] + "\n");
                bw_Note.append("Profile: " + pair[1] + "\n");
                source = pair[2];

                bw_Map.append(directoryName + " -|\n");
                bw_MapAll.append("     |-> " + directoryName + " -|\n");
                File Dir = new File(ojDir);
                File[] fileList = Dir.listFiles();
                levelSpeceSize = new int[11];
                levelSpeceSize[1] = directoryName.length();
                BuildMap(1, ojDir, fileList, false);
                bw_Map.flush();
                bw_Note.flush();

//                System.out.println("source :" + source);
                pair = getWebsite(directoryName);
                String HeadText = "Total SourceCode File: " + pair[3] + ", Accepted File: " + pair[4];
                RandomAccessFile f = new RandomAccessFile(new File(ojMapFile), "rw");
                f.seek(0); // to the beginning
                f.write(HeadText.getBytes());
                f.close();

            }

            bw_MapAll.flush();

            String HeadText = "Total SourceCode File: " + totalJavaFile + ", Accepted File: " + totalAcceptedFile;
            RandomAccessFile f = new RandomAccessFile(new File("./" + MAP_FILE), "rw");
            f.seek(0); // to the beginning
            f.write(HeadText.getBytes());
            f.close();
        }


        System.out.println("Total Online Judge: " + sourceList.size());
        for (OJSource source : sourceList) {
            System.out.println(source.getResult());
        }
    }


    static void BuildMap(int level, String ojDir, File[] files, boolean isAccepted) throws IOException {
        boolean ac;
        for (int i = 0; i < files.length; i++) {
            bw_MapAll.append("     |");
            for (int k = 1; k <= level; k++) {
                for (int j = 0; j < levelSpeceSize[k] + (k > 1 ? 5 : 2); j++) {
                    bw_Map.append(" ");
                    bw_MapAll.append(" ");
                }
                for (int j = 0; j < (k > 1 ? 0 : 3); j++) {
                    bw_MapAll.append(" ");
                }
                bw_Map.append("|");
                bw_MapAll.append("|");
            }
            if (files[i].isDirectory()) {

                if (files[i].getName().equals("Accepted")
                        || files[i].getParentFile().getName().equals("Accepted")
                        || files[i].getParentFile().getParentFile().getName().equals("Accepted")
                        ) {
                    ac = true;
                } else {
                    ac = false;
                }

                String nowDir = ojDir + "/" + files[i].getName();
                File Dir = new File(nowDir);
                File[] fileList = Dir.listFiles();
                bw_Map.append("-> " + files[i].getName() + (fileList.length > 0 ? " -|" : "") + "\n");
                bw_MapAll.append("-> " + files[i].getName() + (fileList.length > 0 ? " -|" : "") + "\n");
                if (fileList.length > 0) {
                    levelSpeceSize[level + 1] = files[i].getName().length();
                    BuildMap(level + 1, nowDir, fileList, ac);
                }
                bw_MapAll.append("     |");
                for (int k = 1; k <= level; k++) {
                    for (int j = 0; j < levelSpeceSize[k] + (k > 1 ? 5 : 2); j++) {
                        bw_Map.append(" ");
                        bw_MapAll.append(" ");
                    }
                    for (int j = 0; j < (k > 1 ? 0 : 3); j++) {
                        bw_MapAll.append(" ");
                    }
                    bw_Map.append("|");
                    bw_MapAll.append("|");
                }
                bw_Map.newLine();
                bw_MapAll.newLine();
            } else {
                if (files[i].getName().endsWith(".java")) {
                    totalJavaFile++;

                    if (isAccepted) {
                        totalAcceptedFile++;
                    }
                    countingSource(source, isAccepted);//Counting each Source
                }
                bw_Map.append("-- " + files[i].getName() + "\n");
                bw_MapAll.append("-- " + files[i].getName() + "\n");
            }
        }

    }

    private static String[] getWebsite(String directoryName) {
        String[] pair = new String[5];
        for (OJSource source : sourceList) {
            if (source.getName().equals(directoryName)) {
                pair[0] = source.getLink();
                pair[1] = source.getProfile();
                pair[2] = source.getName();
                pair[3] = source.getTotalFile() + "";
                pair[4] = source.getAccepted() + "";
            }
        }
        return pair;
    }

    static void countingSource(String sourceCounting, boolean Accepted) {
        for (OJSource source : sourceList) {
            if (source.name.equals(sourceCounting)) {
                source.addTotalFile();
                if (Accepted) source.addAccepted();
                break;
            }
        }
    }


}
