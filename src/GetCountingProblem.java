import java.io.*;

/**
 * Created by Teerapat_
 */

public class GetCountingProblem {
    static final String ROOT_DIRECTORY = "src";
    static final String NOTE_FILE = "NOTE.txt";
    static final String MAP_FILE = "MAP.txt";

    static final String AIZU = "AIZU";
    static final String LINK_AIZU = "http://judge.u-aizu.ac.jp/onlinejudge/";
    static final String PROFILE_AIZU = "http://judge.u-aizu.ac.jp/onlinejudge/user.jsp?id=teerapat_";
    static int aizu_totalFile = 0;
    static int aizu_ac = 0;

    static final String CODECHEF = "CODECHEF";
    static final String LINK_CODECHEF = "https://www.codechef.com/";
    static final String PROFILE_CODECHEF = "https://www.codechef.com/users/teerapat_";
    static int codechef_totalFile = 0;
    static int codechef_ac = 0;

    static final String COJ = "COJ";
    static final String LINK_COJ = "http://coj.uci.cu/index.xhtml";
    static final String PROFILE_COJ = "";
    static int coj_totalFile = 0;
    static int coj_ac = 0;

    static final String TOPCODER = "TOPCODER";
    static final String LINK_TOPCODER = "https://www.topcoder.com/";
    static final String PROFILE_TOPCODER = "";
    static int topcoder_totalFile = 0;
    static int topcoder_ac = 0;

    static final String URI = "URI";
    static final String LINK_URI = "https://www.urionlinejudge.com.br/judge/en";
    static final String PROFILE_URI = "https://www.urionlinejudge.com.br/judge/en/profile/56315";
    static int uri_totalFile = 0;
    static int uri_ac = 0;

    static final String UVA = "UVA";
    static final String LINK_UVA = "https://uva.onlinejudge.org/";
    static final String PROFILE_UVA = "UserName:boombarm | Online Judge ID: 752084";
    static int uva_totalFile = 0;
    static int uva_ac = 0;

    static final String ZOJ = "ZOJ";
    static final String LINK_ZOJ = "http://acm.zju.edu.cn/onlinejudge/";
    static final String PROFILE_ZOJ = "";
    static int zoj_totalFile = 0;
    static int zoj_ac = 0;

    static final String SPOJ = "SPOJ";
    static final String LINK_SPOJ = "http://acm.zju.edu.cn/onlinejudge/";
    static final String PROFILE_SPOJ = "";
    static int spoj_totalFile = 0;
    static int spoj_ac = 0;

    static final String DEV_SKILL = "DEVSKILL";
    static final String LINK_DEV_SKILL = "https://www.devskill.com/Home";
    static final String PROFILE_DEV_SKILL = "";
    static int devSkill_totalFile = 0;
    static int devSkill_ac = 0;

    static final String CODERBYTE = "CODERBYTE";
    static final String LINK_CODERBYTE = "";
    static final String PROFILE_CODERBYTE = "";
    static int coderByte_totalFile = 0;
    static int coderByte_ac = 0;

    static final String HACKERRANK = "HACKERRANK";
    static final String LINK_HACKERRANK = "";
    static final String PROFILE_HACKERRANK = "";
    static int hackerRank_totalFile = 0;
    static int hackerRank_ac = 0;

    static final String HACKEREARTH = "HACKEREARTH";
    static final String LINK_HACKEREARTH = "https://www.hackerearth.com/";
    static final String PROFILE_HACKEREARTH = "";
    static int hackerEarth_totalFile = 0;
    static int hackerEarth_ac = 0;

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
        System.out.println("Counting File Result");
        System.out.println(AIZU + " totalFile:" + aizu_totalFile + "  ac:" + aizu_ac);
        System.out.println(COJ + " totalFile:" + coj_totalFile + "  ac:" + coj_ac);
        System.out.println(URI + " totalFile:" + uri_totalFile + "  ac:" + uri_ac);
        System.out.println(UVA + " totalFile:" + uva_totalFile + "  ac:" + uva_ac);
        System.out.println(ZOJ + " totalFile:" + zoj_totalFile + "  ac:" + zoj_ac);
        System.out.println(SPOJ + " totalFile:" + spoj_totalFile + "  ac:" + spoj_ac);
        System.out.println(HACKEREARTH + " totalFile:" + hackerEarth_totalFile + " ac:" + hackerEarth_ac);
        System.out.println(HACKERRANK + " totalFile:" + hackerRank_totalFile + " ac:" + hackerRank_ac);
        System.out.println(TOPCODER + " totalFile:" + topcoder_totalFile + " ac:" + topcoder_ac);
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
        switch (directoryName) {
            case AIZU:
                pair[0] = LINK_AIZU;
                pair[1] = PROFILE_AIZU;
                pair[2] = AIZU;
                pair[3] = aizu_totalFile + "";
                pair[4] = aizu_ac + "";
                break;
            case COJ:
                pair[0] = LINK_COJ;
                pair[1] = PROFILE_COJ;
                pair[2] = COJ;
                pair[3] = coj_totalFile + "";
                pair[4] = coj_ac + "";
                break;
            case SPOJ:
                pair[0] = LINK_SPOJ;
                pair[1] = PROFILE_SPOJ;
                pair[2] = SPOJ;
                pair[3] = spoj_totalFile + "";
                pair[4] = spoj_ac + "";
                break;
            case TOPCODER:
                pair[0] = LINK_TOPCODER;
                pair[1] = PROFILE_TOPCODER;
                pair[2] = TOPCODER;
                pair[3] = topcoder_totalFile + "";
                pair[4] = topcoder_ac + "";
                break;
            case CODECHEF:
                pair[0] = LINK_CODECHEF;
                pair[1] = PROFILE_CODECHEF;
                pair[2] = CODECHEF;
                pair[3] = codechef_totalFile + "";
                pair[4] = codechef_ac + "";
                break;
            case URI:
                pair[0] = LINK_URI;
                pair[1] = PROFILE_URI;
                pair[2] = URI;
                pair[3] = uri_totalFile + "";
                pair[4] = uri_ac + "";
                break;
            case UVA:
                pair[0] = LINK_UVA;
                pair[1] = PROFILE_UVA;
                pair[2] = UVA;
                pair[3] = uva_totalFile + "";
                pair[4] = uva_ac + "";
                break;
            case ZOJ:
                pair[0] = LINK_ZOJ;
                pair[1] = PROFILE_ZOJ;
                pair[2] = ZOJ;
                pair[3] = zoj_totalFile + "";
                pair[4] = zoj_ac + "";
                break;
            case DEV_SKILL:
                pair[0] = LINK_DEV_SKILL;
                pair[1] = PROFILE_DEV_SKILL;
                pair[2] = DEV_SKILL;
                pair[3] = devSkill_totalFile + "";
                pair[4] = devSkill_ac + "";
                break;
            case CODERBYTE:
                pair[0] = LINK_CODERBYTE;
                pair[1] = PROFILE_CODERBYTE;
                pair[2] = CODERBYTE;
                pair[3] = coderByte_totalFile + "";
                pair[4] = coderByte_ac + "";
                break;
            case HACKERRANK:
                pair[0] = LINK_HACKERRANK;
                pair[1] = PROFILE_HACKERRANK;
                pair[2] = HACKERRANK;
                pair[3] = hackerRank_totalFile + "";
                pair[4] = hackerRank_ac + "";
                break;
            case HACKEREARTH:
                pair[0] = LINK_HACKEREARTH;
                pair[1] = PROFILE_HACKEREARTH;
                pair[2] = HACKEREARTH;
                pair[3] = hackerEarth_totalFile + "";
                pair[4] = hackerEarth_ac + "";
                break;
            default:
                pair[0] = "";
                pair[1] = "";
                break;
        }
        return pair;
    }

    static void countingSource(String source, boolean Accepted) {

        switch (source) {
            case AIZU:
                aizu_totalFile++;
                if (Accepted) aizu_ac++;
                break;
            case COJ:
                coj_totalFile++;
                if (Accepted) coj_ac++;
                break;
            case CODECHEF:
                codechef_totalFile++;
                if (Accepted) codechef_ac++;
                break;
            case CODERBYTE:
                coderByte_totalFile++;
                if (Accepted) coderByte_ac++;
            case SPOJ:
                spoj_totalFile++;
                if (Accepted) spoj_ac++;
                break;
            case TOPCODER:
                topcoder_totalFile++;
                if (Accepted) topcoder_ac++;
                break;
            case URI:
                uri_totalFile++;
                if (Accepted) uri_ac++;
                break;
            case UVA:
                uva_totalFile++;
                if (Accepted) uva_ac++;
                break;
            case ZOJ:
                zoj_totalFile++;
                if (Accepted) zoj_ac++;
                break;
            case DEV_SKILL:
                devSkill_totalFile++;
                if (Accepted) devSkill_ac++;
            case HACKERRANK:
                hackerRank_totalFile++;
                if (Accepted) hackerRank_ac++;
                break;
            case HACKEREARTH:
                hackerEarth_totalFile++;
                if (Accepted) hackerEarth_ac++;
            default:
                break;
        }
    }


}
