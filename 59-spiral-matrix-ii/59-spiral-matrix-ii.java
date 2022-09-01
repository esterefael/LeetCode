class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0, c = 0, dirIndex = 0, nextR, nextC, cnt = 1;
        while(cnt <= n * n){
            res[r][c] = cnt++;
            nextR = r + dir[dirIndex][0];
            nextC = c + dir[dirIndex][1];
            if(nextR == -1 || nextR == n || nextC == -1 || nextC == n || res[nextR][nextC] != 0)
                dirIndex = (dirIndex + 1) % 4;
            r += dir[dirIndex][0];
            c += dir[dirIndex][1];            
        }
        return res;
    }
}