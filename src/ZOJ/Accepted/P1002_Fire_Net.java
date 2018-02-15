package accepted;


/**
 *
 * @author Teerapat Phokhonwong
 */
//ZOJ 1002 Fire Net http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemId=2
//Accepted 2015-10-21 19:57:36 Run Time(ms):29 Run Memory(KB):660
//Algo: DFS
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1002_FireNet {

    static final char WAll = 'X';
    static final char SPACE = '.';
    static final char BLOCK_HOUSE = 'B';
    static final char NOT_PLACE = 'N';
    static int maxBlockHouse = 0;
    static int newBlockHouse = 0;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(new FileInputStream("src/input/P1002.txt"));
//        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] board;
        int n;
        String inputLine = "";
        while ((inputLine = br.readLine()) != null) {
            n = Integer.parseInt(inputLine);
            if (n == 0) {
                break;
            }
            int wallCount = 0;
            maxBlockHouse = 0;
            board = new char[n][n];
            //Create Board
            for (int i = 0; i < n; i++) {
                inputLine = br.readLine();
                for (int j = 0; j < n; j++) {
                    board[i][j] = inputLine.charAt(j);
                    if (board[i][j] == WAll) {
                        wallCount++;
                    }
                }
            }
            if (wallCount == 0) {
                bw.write(n + "\n");
            } else if (wallCount == n * n - 1) {
                bw.write("1\n");
            } else if (wallCount == n * n) {
                bw.write("0\n");
            } else {
                dfs(board);
                bw.write(maxBlockHouse + "\n");
            }
            bw.flush();
        }

    }

    static void dfs(char[][] board) {
        if (newBlockHouse > maxBlockHouse) {
            maxBlockHouse = newBlockHouse;
        }
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[y][x] == WAll || board[y][x] == NOT_PLACE) {
                    continue;
                } else if (check(board, y, x)) {// if can put a BlockHouse
                    board[y][x] = NOT_PLACE;
                    newBlockHouse++;
                    dfs(board);
                    board[y][x] = SPACE;
                    newBlockHouse--;
                }
            }
        }
    }

    static boolean check(char[][] board, int y, int x) {
        for (int i = x + 1; i < board.length; i++) {// check right direction  
            if (board[y][i] == WAll) {
                break;
            } else if (board[y][i] == NOT_PLACE) {
                return false;
            }
        }
        for (int i = x - 1; i >= 0; i--) {// check left direction  
            if (board[y][i] == WAll) {
                break;
            } else if (board[y][i] == NOT_PLACE) {
                return false;
            }
        }
        for (int i = y + 1; i < board.length; i++) {// check down direction  
            if (board[i][x] == WAll) {
                break;
            } else if (board[i][x] == NOT_PLACE) {
                return false;
            }
        }
        for (int i = y - 1; i >= 0; i--) {// check up direction  
            if (board[i][x] == WAll) {
                break;
            } else if (board[i][x] == NOT_PLACE) {
                return false;
            }
        }
        return true;
    }

    static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

}