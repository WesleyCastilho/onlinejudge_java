package MYTOOLS;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teerapat_
 */
public class DB_CountingProblem {

    static final List<OJSource> sourceList = new ArrayList<OJSource>();

    static {
        try {
            File file = new File("src/MYTOOLS/online_judge.xml");
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("ojsource");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    OJSource ojSource = new OJSource();
                    ojSource.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    ojSource.setLink(eElement.getElementsByTagName("link").item(0).getTextContent());
                    ojSource.setProfile(eElement.getElementsByTagName("profile").item(0).getTextContent());
                    sourceList.add(ojSource);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                if (file != null && isIgnoreDirectory(file)) continue;

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
            if (files[i].isDirectory()) {
                if (files[i] != null && files[i].getName().toUpperCase().equals("TRYING")) continue;

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
                if (isIgnoreFile(files[i])) continue;


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
                break;
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

    static boolean isIgnoreFile(File file) {
        String name = file.getName();
        String[] ignoreList = {"MAP.txt", "NOTE.txt"};
        for (String ignore : ignoreList) {
            if (name.equals(ignore)) return true;
        }
        return false;
    }

    static boolean isIgnoreDirectory(File file){
        String name = file.getName();
        String[] ignoreList= {"MYTOOLS",
                "STRUCTURE_AND_ALGORITHM",
                "TOPCODER",
                "CODERBYTE",
                "UVA",
                "ICPC_LIVE_ARCHIVE",
                "HACKERRANK",
                "HACKEREARTH",
                "GOOGLE_CODEJAM",
                "CODINGAME",
                "CODERBYTE",
                "CODEFORCES",
                "CODECHEF"
        };
        for (String ignore : ignoreList) {
            if (name.equals(ignore)) return true;
        }
        return false;
    }


}
