package MYTOOLS;


import java.util.Random;

public class SortMultipleField {

    static int[][] data;
    //    static int[] dataChanged;
    static int[][] dataChanged;
    static int dataSize = 10;
    private static final int ASC = 0;
    private static final int DESC = 1;
    //ASC = น้อย ไป มาก , DESC = มาก ไป น้อย
    static int[] columnSortType = new int[]{DESC, DESC, DESC, DESC, ASC};

    static {
        data = new int[][]{
                {56, 42, 17, 22, 57},
                {86, 7, 4, 85, 79},
                {31, 70, 17, 62, 17},
                {2, 75, 61, 59, 60},
                {2, 68, 29, 23, 51},
                {85, 26, 42, 75, 71},
                {9, 1, 29, 79, 21},
                {13, 52, 41, 71, 10},
                {46, 61, 1, 12, 17},
                {88, 81, 22, 75, 41}

//                {55, 1, 55, 55, 1},
//                {55, 2, 55, 55, 2},
//                {55, 3, 55, 55, 3},
//                {55, 4, 55, 55, 4},
//                {55, 5, 55, 55, 5},
//                {55, 6, 55, 55, 6},
//                {55, 7, 55, 55, 7},
//                {55, 8, 55, 55, 8},
//                {55, 9, 55, 55, 9},
//                {55, 10, 55, 55, 10}
        };

//        dataChanged = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        dataChanged = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
    }


    public static void main(String[] args) {
        Random rd = new Random();
//        data = new int[dataSize][5];
        for (int i = 0; i < dataSize; i++) {
//            data[i][0] = rd.nextInt(100) + 1;
//            data[i][1] = rd.nextInt(100) + 1;
//            data[i][2] = rd.nextInt(100) + 1;
//            data[i][3] = rd.nextInt(100) + 1;
//            data[i][4] = rd.nextInt(100) + 1;
            System.out.println(data[i][0] + "   " + data[i][1] + "   " + data[i][2] + "   " + data[i][3] + "   " + data[i][4]);
        }


//        sort(data, 0, dataSize - 1);

        //bubble sort

        while (true) {
            boolean found = false;
            for (int i = 0; i < dataSize - 1; i++) {
                if (compare(data, i, i + 1)) {
                    int[] tmp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = tmp;
                    found = true;
                }
            }


            if (!found) break;
        }

        System.out.println("\n\n\nAfter sort");
        for (int i = 0; i < dataSize; i++) {
            System.out.println(data[i][0] + "   " + data[i][1] + "   " + data[i][2] + "   " + data[i][3] + "   " + data[i][4] + "      sum = " + (data[i][0] + data[i][1] + data[i][2] + data[i][3] + data[i][4]));
        }


//        System.out.println();
//        for (int i = 0; i < dataSize; i++) {
//            System.out.println(dataChanged[i][0] + "   " + dataChanged[i][1] + "   " + dataChanged[i][2] + "   " + dataChanged[i][3] + "   " + dataChanged[i][4] +" = "+(dataChanged[i][0] + dataChanged[i][1] +  dataChanged[i][2] +dataChanged[i][3] +  dataChanged[i][4]));
//        }
    }

//    static stableSort() {
//
//    }

    static boolean compare(int[][] data, int i, int j) {
        int a = 0;
        int b = 0;
        for (int now = 0; now < 5; now++) {
            if (data[i][now] == data[j][now]) continue;
            if (columnSortType[now] == ASC) {
                if (data[i][now] > data[j][now]) {
                    a++;
                }
            } else {
                if (data[i][now] < data[j][now]) {
                    b++;
                }
            }
        }
        System.out.println(a + "    " + b);
        return a != b;
    }


    private static void sort(int[][] data, int start, int end) {
        for (int i = 0; i < 5; i++) {
            quickSort(data, start, end, i, columnSortType[i]);
//            System.out.println();
        }
    }

    private static int partitionASC(int[][] data, int start, int end, int column) {
        //sort by row
        int pivot = data[end][column];
        for (int i = start; i < end; i++) {
            if (data[i][column] < pivot) {
                int[] temp = data[start];
                data[start] = data[i];
                data[i] = temp;
                start++;
            }
        }
        int[] temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        return start;

        //sort by data
//        int pivot = data[end][column];
//        for (int i = start; i < end; i++) {
//            if (data[i][column] < pivot) {
//                int temp = data[start][column];
//                data[start][column] = data[i][column];
//                data[i][column] = temp;
//
//                start++;
//            }
//        }
//        int temp = data[start][column];
//        data[start][column] = data[end][column];
//        data[end][column] = temp;
//
//        return start;


    }

//    private static int partitionASC(int[][] data, int i, int j, int column) {
//        int pivot = data[j][column];
//        for (int index = i; index < j; index++) {
//            if (data[i][column] > pivot) {
//                int temp = data[i][column];
//                data[i][column] = data[index][column];
//                data[index][column] = temp;
//                i++;
//            }
//        }
//        int temp = data[i][column];
//        data[i][column] = pivot;
//        data[j][column] = temp;
//        return i;
//
//
////        while (true) {
////
////            while (data[i][column] < pivot) {
////                i++;
////            }
////
////            while (data[j][column] > pivot) {
////                j--;
////            }
////
////            if (i < j) {
////                int[] temp = data[i];
////                data[i] = data[j];
////                data[j] = temp;
////                dataChanged[i]++;
////                dataChanged[j]--;
////                i++;
////                j--;
////            } else {
////                return j;
////            }
////        }
//    }


    private static int partitionDESC(int[][] data, int start, int end, int column) {
        //sort by row
        int pivot = data[end][column];
        for (int i = start; i < end; i++) {
            if (data[i][column] > pivot) {
                int[] temp = data[start];
                data[start] = data[i];
                data[i] = temp;
                start++;
            }
        }
        int[] temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        return start;

//        //sort by data
//        int pivot = data[end][column];
//        for (int i = start; i < end; i++) {
//            if (data[i][column] > pivot) {
//                int temp = data[start][column];
//                data[start][column] = data[i][column];
//                data[i][column] = temp;
//
//
//                start++;
//            }
//        }
//        int temp = data[start][column];
//        data[start][column] = data[end][column];
//        data[end][column] = temp;
//
//        return start;

//        while (true) {
//            //ignore all the numbers greater than pivot to left
//            while (data[i][column] > pivot) {
//                i++;
//            }
//            //ignore all numbers lesser than pivot to right
//            while (data[j][column] < pivot) {
//                j--;
//            }
//
//            //swap a number lesser than X on left with a number greater than X on right
//            if (i < j) {
//                int[] temp = data[i];
//                data[i] = data[j];
//                data[j] = temp;
//                dataChanged[i]--;
//                dataChanged[j]++;
//                i++;
//                j--;
//            } else {
//                //Now the array is so sorted, that all numbers lesser than X are on right of it and greater than X are to left of it. Hence return position of X
//                return j;
//            }
//        }
    }


    private static void quickSort(int[][] data, int low, int high, int column, int type) {
        if (low < high) {
            int pi = type == ASC ? partitionASC(data, low, high, column) : partitionDESC(data, low, high, column);
            quickSort(data, low, pi - 1, column, type);
            quickSort(data, pi + 1, high, column, type);
        }
    }


    int compString(String str1, String str2) {
        return str1.compareTo(str2);
    }

}
