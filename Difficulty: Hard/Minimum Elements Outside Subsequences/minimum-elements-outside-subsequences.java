class Solution {
    public int minCount(int[] arr) {
        // code here
        int n = arr.length;
                int MAX = 102;
                int[][] dp = new int[MAX][MAX];

                for (int i = 0; i < MAX; i++) {
                    for (int j = 0; j < MAX; j++) {
                        dp[i][j] = -1;
                    }
                }

                dp[101][0] = 0;

                for (int x : arr) {
                    int[][] next = new int[MAX][MAX];

                    for (int i = 0; i < MAX; i++) {
                        for (int j = 0; j < MAX; j++) {
                            next[i][j] = -1;
                        }
                    }

                    for (int inc = 0; inc < MAX; inc++) {
                        for (int dec = 0; dec < MAX; dec++) {

                            if (dp[inc][dec] == -1) {
                                continue;
                            }

                            int selected = dp[inc][dec];
                            next[inc][dec] = Math.max(
                                next[inc][dec],
                                selected
                            );
                            if (inc == 101 || x > inc) {
                                next[x][dec] = Math.max(
                                    next[x][dec],
                                    selected + 1
                                );
                            }

                            if (dec == 0 || x < dec) {
                                next[inc][x] = Math.max(
                                    next[inc][x],
                                    selected + 1
                                );
                            }
                        }
                    }

                    dp = next;
                }

                int maxSelected = 0;

                for (int inc = 0; inc < MAX; inc++) {
                    for (int dec = 0; dec < MAX; dec++) {
                        maxSelected = Math.max(maxSelected, dp[inc][dec]);
                    }
                }

                return n - maxSelected;
    }
}