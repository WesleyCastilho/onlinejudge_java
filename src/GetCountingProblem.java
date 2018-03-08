import java.io.*;

/**
 * Created by Teerapat-BSD on 3/7/2018.
 */

public class GetCountingProblem {
    static final String ROOT_DIRECTORY = "src";
    static final String NOTE_FILE = "NOTE.txt";
    static final String MAP_FILE = "MAP.txt";

    static final String LINK_AIZU = "http://judge.u-aizu.ac.jp/onlinejudge/";
    static final String PROFILE_AIZU = "http://judge.u-aizu.ac.jp/onlinejudge/user.jsp?id=teerapat_";
    static int aizu_totalFile = 0;

    static final String LINK_COJ = "http://coj.uci.cu/index.xhtml";
    static final String PROFILE_COJ = "";
    static int coj_totalFile = 0;

    static final String LINK_TOPCODER = "https://www.topcoder.com/";
    static final String PROFILE_TOPCODER = "";
    static int topcoder_totalFile = 0;

    static final String LINK_URI = "https://www.urionlinejudge.com.br/judge/en";
    static final String PROFILE_URI = "https://www.urionlinejudge.com.br/judge/en/profile/56315";
    static int uri_totalFile = 0;

    static final String LINK_UVA = "https://uva.onlinejudge.org/";
    static final String PROFILE_UVA = "";
    static int uva_totalFile = 0;

    static final String LINK_ZOJ = "http://acm.zju.edu.cn/onlinejudge/";
    static final String PROFILE_ZOJ = "";
    static int zoj_totalFile = 0;

    static final String LINK_SPOJ = "http://acm.zju.edu.cn/onlinejudge/";
    static final String PROFILE_SPOJ = "";

    static final String LINK_DEV_SKILL = "https://www.devskill.com/Home";
    static final String PROFILE_DEV_SKILL = "";

    static int totalJavaFile = 0;
    static int totalAcceptedFile = 0;
    static BufferedWriter bw_MapAll;
    static BufferedWriter bw_Map;
    static BufferedWriter bw_Note;
    static int[] levelSpeceSize;

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
                bw_Note = new BufferedWriter(new FileWriter(ojNoteFile));
                String[] pair = getWebsite(directoryName);
                bw_Note.append("Website: " + pair[0] + "\n");
                bw_Note.append("Profile: " + pair[1] + "\n");

                bw_Map.append(directoryName + " -|\n");
                bw_MapAll.append("     |-> " + directoryName + " -|\n");
                File Dir = new File(ojDir);
                File[] fileList = Dir.listFiles();
                levelSpeceSize = new int[11];
                levelSpeceSize[1] = directoryName.length();
                BuildMap(1, ojDir, fileList, false);
            }
            bw_Map.flush();
            bw_Note.flush();
            bw_MapAll.flush();

//            String HeadText = "Total SourceCode File: " + totalJavaFile;
            String HeadText = "Total SourceCode File: " + totalJavaFile + ", Accepted File: " + totalAcceptedFile;
            RandomAccessFile f = new RandomAccessFile(new File("./" + MAP_FILE), "rw");
            f.seek(0); // to the beginning
            f.write(HeadText.getBytes());
            f.close();
        }
    }


    static void BuildMap(int level, String ojDir, File[] files, boolean isAccepted) throws IOException {
        boolean ac = isAccepted;
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
                }
                bw_Map.append("-- " + files[i].getName() + "\n");
                bw_MapAll.append("-- " + files[i].getName() + "\n");
            }
        }

    }

    private static String[] getWebsite(String directoryName) {
        String[] pair = new String[2];
        switch (directoryName) {
            case "AIZU":
                pair[0] = LINK_AIZU;
                pair[1] = PROFILE_AIZU;
                break;
            case "COJ":
                pair[0] = LINK_COJ;
                pair[1] = PROFILE_COJ;
                break;
            case "URI":
                pair[0] = LINK_URI;
                pair[1] = PROFILE_URI;
                break;
            case "UVA":
                pair[0] = LINK_UVA;
                pair[1] = PROFILE_UVA;
                break;
            case "ZOJ":
                pair[0] = LINK_ZOJ;
                pair[1] = PROFILE_ZOJ;
                break;
            default:
                pair[0] = "";
                pair[1] = "";
                break;
        }
        return pair;
    }

}
