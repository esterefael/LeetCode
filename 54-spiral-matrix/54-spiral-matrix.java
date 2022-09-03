class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        final int N = matrix.length, M = matrix[0].length;
        List<Integer> res = new LinkedList<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0, c = 0, dirIndex = 0, nextR, nextC;
        while(res.size() < N * M){
            res.add(matrix[r][c]);
            matrix[r][c] = 101;
            nextR = r + dir[dirIndex][0];
            nextC = c + dir[dirIndex][1];
            if(nextR == -1 || nextR == N || nextC == -1 || nextC == M || matrix[nextR][nextC] == 101)
                dirIndex = (dirIndex + 1) % 4;
            r += dir[dirIndex][0];
            c += dir[dirIndex][1];            
        }
        return res;
    }
}