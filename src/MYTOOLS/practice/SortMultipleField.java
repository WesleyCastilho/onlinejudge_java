package MYTOOLS.practice;


public class SortMultipleField {

    static int[][] data;
    //    static int[] dataChanged;
    static int[][] dataChanged;
    static int dataSize = 11;
    private static final int ASC = 0;
    private static final int DESC = 1;
    //ASC = น้อย ไป มาก , DESC = มาก ไป น้อย
    static int[] columnSortType = new int[]{DESC, DESC, DESC, DESC, ASC};

    static {
        data = new int[][]{
                {56, 42, 17, 22, 57},
                {86, 7, 4, 85, 79},
                {86, 7, 4, 85, 78},
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
//        Random rd = new Random();
//        data = new int[dataSize][5];
        for (int i = 0; i < dataSize; i++) {
//            data[i][0] = rd.nextInt(100) + 1;
//            data[i][1] = rd.nextInt(100) + 1;
//            data[i][2] = rd.nextInt(100) + 1;
//            data[i][3] = rd.nextInt(100) + 1;
//            data[i][4] = rd.nextInt(100) + 1;
            System.out.println(data[i][0] + "   " + data[i][1] + "   " + data[i][2] + "   " + data[i][3] + "   " + data[i][4]);
        }


        mergeSort(data, 0, dataSize - 1);

//  quicksort
//        sort(data, 0, dataSize - 1);

        //bubble sort
//        while (true) {
//            boolean found = false;
//            for (int i = 0; i < dataSize - 1; i++) {
//                if (compare(data, i, i + 1)) {
//                    int[] tmp = data[i];
//                    data[i] = data[i + 1];
//                    data[i + 1] = tmp;
//                    found = true;
//                }
//            }
//
//
//            if (!found) break;
//        }

        System.out.println("\n\n\nAfter sort");
        for (int i = 0; i < dataSize; i++) {
            System.out.println(data[i][0] + "   " + data[i][1] + "   " + data[i][2] + "   " + data[i][3] + "   " + data[i][4] + "      sum = " + (data[i][0] + data[i][1] + data[i][2] + data[i][3] + data[i][4]));
        }


//        System.out.println();
//        for (int i = 0; i < dataSize; i++) {
//            System.out.println(dataChanged[i][0] + "   " + dataChanged[i][1] + "   " + dataChanged[i][2] + "   " + dataChanged[i][3] + "   " + dataChanged[i][4] +" = "+(dataChanged[i][0] + dataChanged[i][1] +  dataChanged[i][2] +dataChanged[i][3] +  dataChanged[i][4]));
//        }
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
    }



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


    static void mergeSort(int[][] data, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(data, left, mid);
        mergeSort(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    static void merge(int[][] data, int left, int mid, int right) {
        int i, j, k;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        /* create temp arrays */
        int[][] L = new int[n1][], R = new int[n2][];

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
            L[i] = data[left + i];
        for (j = 0; j < n2; j++)
            R[j] = data[mid + 1 + j];

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = left; // Initial index of merged subarray
        while (i < n1 && j < n2) {
            //compare
            for (int t = 0; t < 5; t++) {
                if (L[i][t] == R[j][t]) continue;
                if (columnSortType[t] == ASC) {
                    if (L[i][t] <= R[j][t]) {
                        data[k] = L[i];
                        i++;
                    } else {
                        data[k] = R[j];
                        j++;
                    }
                    break;
                } else if (columnSortType[t] == DESC) {
                    if (L[i][t] >= R[j][t]) {
                        data[k] = L[i];
                        i++;
                    } else {
                        data[k] = R[j];
                        j++;
                    }
                    break;
                }
            }
            k++;
        }

        /* ก๊อบส่วนที่เหลือของ L[] ลง data[] */
        while (i < n1) {
            data[k] = L[i];
            i++;
            k++;
        }

        /* ก๊อบส่วนที่เหลือลง R [] ลง data[]  */
        while (j < n2) {
            data[k] = R[j];
            j++;
            k++;
        }
    }


}
