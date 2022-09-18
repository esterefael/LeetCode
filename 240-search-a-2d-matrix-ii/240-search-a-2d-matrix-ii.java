class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int R = matrix.length, C = matrix[0].length;
        int r = 0, c = C - 1;
        while(r < R && c > -1){            
            if(matrix[r][c] < target)
                r++;
            else
                if(matrix[r][c] > target)
                    c--;
                else
                    return true;
        }
        return false;
    }
}