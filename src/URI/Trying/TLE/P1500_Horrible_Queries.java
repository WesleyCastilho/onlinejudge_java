/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Jusge
 * @Categories: Data Structures
 * @Problem: 1500 - Horrible Queries
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1500
 * @Timelimit: 4 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution: Segment Tree
 * @Note:
 */
package URI.Trying.TLE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P1500_Horrible_Queries {

    // Java Program to show segment tree operations like construction,
    // query and update
    class SegmentTree {
        int st[]; // The array that stores segment tree nodes

        /* Constructor to construct segment tree from given array. This
           constructor  allocates memory for segment tree and calls
           constructSTUtil() to  fill the allocated memory */
        SegmentTree(int arr[], int n) {
            // Allocate memory for segment tree
            //Height of segment tree
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

            //Maximum size of segment tree
            int max_size = 2 * (int) Math.pow(2, x) - 1;

            st = new int[max_size]; // Memory allocation

            constructSTUtil(arr, 0, n - 1, 0);
        }

        // A utility function to get the middle index from corner indexes.
        int getMid(int s, int e) {
            return s + (e - s) / 2;
        }

        /*  A recursive function to get the sum of values in given range
            of the array.  The following are parameters for this function.

          st    --> Pointer to segment tree
          si    --> Index of current node in the segment tree. Initially
                    0 is passed as root is always at index 0
          ss & se  --> Starting and ending indexes of the segment represented
                        by current node, i.e., st[si]
          qs & qe  --> Starting and ending indexes of query range */
        int getSumUtil(int ss, int se, int qs, int qe, int si) {
            // If segment of this node is a part of given range, then return
            // the sum of the segment
            if (qs <= ss && qe >= se)
                return st[si];

            // If segment of this node is outside the given range
            if (se < qs || ss > qe)
                return 0;

            // If a part of this segment overlaps with the given range
            int mid = getMid(ss, se);
            return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                    getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
        }

        /* A recursive function to update the nodes which have the given
           index in their range. The following are parameters
            st, si, ss and se are same as getSumUtil()
            i    --> index of the element to be updated. This index is in
                     input array.
           diff --> Value to be added to all nodes which have i in range */
        void updateValueUtil(int ss, int se, int i, int diff, int si) {
            // Base Case: If the input index lies outside the range of
            // this segment
            if (i < ss || i > se)
                return;

            // If the input index is in range of this node, then update the
            // value of the node and its children
            st[si] = st[si] + diff;
            if (se != ss) {
                int mid = getMid(ss, se);
                updateValueUtil(ss, mid, i, diff, 2 * si + 1);
                updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
            }
        }

        // The function to update a value in input array and segment tree.
        // It uses updateValueUtil() to update the value in segment tree
        void updateValue(int arr[], int n, int i, int new_val) {
            // Check for erroneous input index
            if (i < 0 || i > n - 1) {
                System.out.println("Invalid Input");
                return;
            }

            // Get the difference between new value and old value
            int diff = new_val - arr[i];

            // Update the value in array
            arr[i] = new_val;

            // Update the values of nodes in segment tree
            updateValueUtil(0, n - 1, i, diff, 0);
        }

        // Return sum of elements in range from index qs (quey start) to
        // qe (query end).  It mainly uses getSumUtil()
        int getSum(int n, int qs, int qe) {
            // Check for erroneous input values
            if (qs < 0 || qe > n - 1 || qs > qe) {
                System.out.println("Invalid Input");
                return -1;
            }
            return getSumUtil(0, n - 1, qs, qe, 0);
        }

        // A recursive function that constructs Segment Tree for array[ss..se].
        // si is index of current node in segment tree st
        int constructSTUtil(int arr[], int ss, int se, int si) {
            // If there is one element in array, store it in current node of
            // segment tree and return
            if (ss == se) {
                st[si] = arr[ss];
                return arr[ss];
            }

            // If there are more than one elements, then recur for left and
            // right subtrees and store the sum of values in this node
            int mid = getMid(ss, se);
            st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
                    constructSTUtil(arr, mid + 1, se, si * 2 + 2);
            return st[si];
        }
    }

    public P1500_Horrible_Queries() throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        int t = Integer.parseInt(br.readLine());
        int n, c;
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]) + 1;
            c = Integer.parseInt(st[1]);
            int[] data = new int[n];
            SegmentTree segmentTree = new SegmentTree(data, n);
            while (c-- > 0) {
                st = br.readLine().split(" ");
                int start = Integer.parseInt(st[1]);
                int end = Integer.parseInt(st[2]);
                switch (st[0]) {
                    case "0":
                        int value = Integer.parseInt(st[3]);
                        for (int i = start; i <= end; i++) {
                            segmentTree.updateValue(data, n, i, value);
                        }
                        break;
                    case "1":
                        bw.append(segmentTree.getSum(n, start, end) + "\n");
                        break;
                }
            }
        }
        bw.flush();
    }

}
