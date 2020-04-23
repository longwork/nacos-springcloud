package wimi.nacos.springboot;

/**
 * @author Long
 * @date 16:08 2020-04-21 周二
 */
public class EightQueen1212 {
    static int[][] Array = new int[8][8];
    static int tot = 0;

    private static final int MAX_VALUE = 8;
    private static final int LESS_THAN = 7;

    public static void main(String[] args) {
        findQueen(0);
        System.out.println(tot);
    }

    private static void findQueen(int i) {
        if (i > LESS_THAN) {
            print();
            ++tot;
            return;
        }
        for (int m = 0; m < MAX_VALUE; m++) {
            if (check(i, m)) {
                Array[i][m] = 1;
                findQueen(i + 1);
                Array[i][m] = 0;
            }
        }

    }

    private static boolean check(int k, int j) {
        for (int i = 0; i < MAX_VALUE; i++) {
            if (Array[i][j] == 1) {
                return false;
            }
        }
        for (int i = k - 1, m = j - 1; i >= 0 && m >= 0; i--, m--) {
            if (Array[i][m] == 1) {
                return false;
            }
        }
        for (int i = k - 1, m = j + 1; i >= 0 && m <= LESS_THAN; i--, m++) {
            if (Array[i][m] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void print() {
        for (int i = 0; i < MAX_VALUE; i++) {
            for (int j = 0; j < MAX_VALUE; j++) {
                if (Array[i][j] == 1) {
                    System.out.print(j);
                }
            }
        }
        System.out.println();
    }
}
