package knapsack;


import java.util.*;

class Knapsack {
    int[] size;
    int[] value;
    int N;

    public Knapsack(int[] size, int[] value) {
        if (size.length != value.length) {
            throw new IllegalArgumentException("'size'と'value'の要素数が一致していません");
        }

        this.N = size.length;
        this.size = (int[])size.clone();
        this.value = (int[])value.clone();
    }


    public void solve(int m) {
        int[] total = new int[m+1];
        int[] choice = new int[m+1];
        Arrays.fill(choice, -1);
        int repackTotal;

        for (int i = 0; i < N; i++) {
            for (int j = size[i]; j <= m; j++) {
                repackTotal = total[j - size[i]] + value[i];
                if (repackTotal > total[j]) {
                    total[j] = repackTotal;
                    choice[j] = i;
                }
            }

            System.out.printf("i = %d%n", i);
            System.out.printf("total = ");
            for (int j = 0; j <= m; j++) {
                System.out.printf("%4d", total[j]);
            }
            System.out.printf("%nchoice = ");
            for (int j = 0; j <= m; j++) {
                System.out.printf("%4d", choice[j]);
            }
            System.out.printf("%n!!!!!!!!%n");
            System.out.printf("\n");
        }

        for (int i = m; choice[i] >= 0; i -= size[choice[i]]) {
            System.out.printf("品物 %d (価値 %d) を詰め込む %n", choice[i], value[choice[i]]);
        }
        System.out.printf("価値の合計 = %d%n", total[m]);
    }

}
