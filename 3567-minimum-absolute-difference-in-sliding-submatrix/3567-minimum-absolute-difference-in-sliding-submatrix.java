class Solution {
    private int calculate(int[][] grid, int i, int j, int k) {
        if (k * k == 1) {
            return 0;
        }
        int[] temp = new int[k * k];
        int idx = 0;
        for (int a = i; a < i + k; a++) {
            for (int b = j; b < j + k; b++) {
                temp[idx++] = grid[a][b];
            }
        }
        Arrays.sort(temp);
        int min = Integer.MAX_VALUE;
        for (int a = 1; a < temp.length; a++) {
            if (temp[a] != temp[a - 1]) {
                min = Math.min(min, temp[a] - temp[a - 1]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m - k + 1][n - k + 1];
        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                res[i][j] = calculate(grid, i, j, k);
            }
        }
        return res;
    }
}