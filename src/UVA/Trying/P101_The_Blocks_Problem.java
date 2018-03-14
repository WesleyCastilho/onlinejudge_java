package UVA.Trying;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: UVA Online Judge
 * @Problem: 101 - The Blocks Problem
 * @Link: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=37
 * @Timelimit: 3 seconds
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: LinkedList
 * @Note: (onto = แทรกกลาง)  (over = วางต่อหลัง)
 */

import java.io.*;

public class P101_The_Blocks_Problem {

    static class StackSlot {
        int slotId;
        Block firstBlock = null;
        Block lastBlock = null;

        public StackSlot(int slotId, Block block) {
            this.slotId = slotId;
            this.firstBlock = block;
            this.lastBlock = block;
        }

    }

    static class Block {
        int id;
        int slot;
        Block under = null;
        Block upper = null;

        public Block(int id, int slot) {
            this.id = id;
            this.slot = slot;
        }
    }

    static Block[] block;
    static StackSlot[] slot;

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/UVA/Trying/input/P101_input.txt");
        File outputFile = new File("src/UVA/Trying/output/P101_output.txt");
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        block = new Block[n];
        slot = new StackSlot[n];
        for (int i = 0; i < n; i++) {
            block[i] = new Block(i, i);
            slot[i] = new StackSlot(i, block[i]);
        }
        String input;
        while (!(input = br.readLine()).equals("quit")) {
//            System.out.println(input);

            String[] command = input.split(" ");
            int a = Integer.parseInt(command[1]);
            int b = Integer.parseInt(command[3]);
            Block blockA = block[a];
            Block blockB = block[b];
            StackSlot slotA, slotB;


            switch (command[0]) {
                case "move":
                    slotA = slot[blockA.slot];
                    slotB = slot[blockB.slot];
                    setSlot(blockA, slotB.slotId);
                    Block tmpA_under = blockA.under;
                    switch (command[2]) {
                        case "onto": //move A Onto B  (slot: ...B <-> A)
                            if (slotB.lastBlock != null)
                                slotB.lastBlock.upper = blockA;
                            blockA.under = slotB.lastBlock;
                            slotB.lastBlock = slotA.lastBlock;
                            slotA.lastBlock = tmpA_under;

                            if (slotA.lastBlock == null) {
                                slotA.firstBlock = null;
                            }
                            break;
                        case "over"://move A Over B
                            if (slotB.lastBlock != null) {
                                slotB.lastBlock.upper = blockA;
                                blockA.under = slotB.lastBlock;
                                slotB.lastBlock = slotA.lastBlock;
                            } else {
                                slotB.lastBlock = blockA;
                                slotB.firstBlock = blockA;
                            }

                            slotA.lastBlock = tmpA_under;
                            if (slotA.lastBlock == null) {
                                slotA.firstBlock = null;
                            }
                            break;
                    }
                    break;
                case "pile":
                    slotA = slot[blockA.slot];
                    slotB = slot[b];
                    setSlot(blockA, slotB.slotId);
                    Block tmpB_upper = blockB.upper;
                    Block tmpA_lastBlock = slotA.lastBlock;

                    if (blockA != slotA.firstBlock) {
                        slotA.lastBlock = blockA.under;
                        if(slotA.lastBlock != null)
                        slotA.lastBlock.upper = null;
                    } else {
                        slotA.firstBlock = null;
                        slotA.lastBlock = null;
                    }
                    switch (command[2]) {
                        case "onto"://pile A Onto B
                            if (blockB == slotB.lastBlock) {
                                blockB.upper = blockA;
                                blockA.under = blockB;
                                slotB.lastBlock = slotA.lastBlock;
                            } else {
                                blockB.upper = blockA;
                                blockA.under = blockB;

                                if (tmpA_lastBlock != null)
                                    tmpA_lastBlock.upper = tmpB_upper;
                                if (tmpB_upper != null)
                                    tmpB_upper.under = tmpA_lastBlock;
                            }
                            break;
                        case "over"://pile A Over B

                            if (slotB.firstBlock == null) {
                                slotB.firstBlock = blockA;
                                slotB.lastBlock = slotA.lastBlock;
                            } else {
                                if (slotB.lastBlock != null) {
                                    slotB.lastBlock.upper = blockA;
                                }
                                blockA.under = slotB.lastBlock;
                                slotB.lastBlock = slotA.lastBlock;
                            }
                            break;
                    }
                    break;
            }
//            printResultStep(n);
        }

        for (int i = 0; i < n; i++) {
            bw.append(i + ":");
            Block block = slot[i].firstBlock;
            while (block != null) {
                bw.append(" " + block.id);
                block = block.upper;
            }
            bw.newLine();
        }
        bw.flush();
    }

    static void setSlot(Block block, int newSlot) {
        while (block != null) {
            block.slot = newSlot;
            block = block.upper;
        }
    }

    static void printResultStep(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ":");
            Block block = slot[i].firstBlock;
            while (block != null) {
                System.out.print(" " + block.id);
                block = block.upper;
            }
            System.out.println();
        }
        System.out.println();
    }

}
