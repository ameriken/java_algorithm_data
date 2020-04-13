package knapsack;

public class Main {

    public static void main(String args[]) {
        Knapsack knapsack = new Knapsack(
                new int[] {2, 3, 5, 7, 9},  //size
                new int[] {2, 4, 7, 11, 14} //value
        );

        int size = 0;
        if (args.length != 1) {
            abort("パラメータの個数が違います。");
        }
        try {
            size = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            abort("大きさには正の整数を指定してください");
        }
        if (size <= 0) {
            abort("大きさには正の整数を指定してください");
        }

        knapsack.solve(size);
    }

    public static void abort(String message) {
        System.err.printf("起動法: java Knapsack 大きさ%n");
        System.err.printf("%s%n", message);
        System.exit(1);
    }

}
