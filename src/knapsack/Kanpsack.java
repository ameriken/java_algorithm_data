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
        System.out.printf("ナップザックの大きさは%d%n", m);
        System.out.printf("total =" + Arrays.toString(total) + "%n");
        System.out.printf("choice =" + Arrays.toString(choice) + "%n");
        System.out.printf("size =" + Arrays.toString(size) + "%n");
        System.out.printf("value =" + Arrays.toString(value) + "%n");
        System.out.printf("======%n");

        // iは品物の指定できるかず
        for (int i = 0; i < N; i++) {
            // j = 2
            // size[i] = 2
            // m = 3
            // value[0] = 2
            // mはナップザックの大きさ


            // ナップザック の大きさmと指定があるため
            // m以下を計算する必要がない
            // そのためj =size[i];となる

            // 1)下記の繰り返し
            // 大きさが3のナップザック にjがどのくらい入るか 1ループ目
            // 大きさが3のナップザック にjがどのくらい入るか 2ループ目
            // 大きさが3のナップザック にjがどのくらい入るか 3ループ目

            for (int j = size[i]; j <= m; j++) {
                //System.out.printf("j =" + j + "%n");
                //System.out.printf("size =" + (j - size[i]) + "%n");
                System.out.printf("j = " + j + "%n");
                // 価値の値を入れてる
                repackTotal = total[j - size[i]] + value[i];
                System.out.printf("repackTotal = " + repackTotal + "%n");
                System.out.printf("choice =" + Arrays.toString(choice) + "%n");
                //System.out.printf("repackTotal = " + repackTotal + "%n");
                if (repackTotal > total[j]) {
                    total[j] = repackTotal;
                    choice[j] = i;
                }
                System.out.printf("total =" + Arrays.toString(total) + "%n");
                System.out.printf("choice =" + Arrays.toString(choice) + "%n");
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