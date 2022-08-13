class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
                
        double[][] amount = new double[query_row + 2][query_row + 2];
        amount[0][0] = poured;
        for(int r = 0; r <= query_row; r ++)
            for(int c = 0; c <= r; c++){
                
                if(amount[r][c] <= 1)
                    continue;
                double divide = (amount[r][c] - 1) / 2;
                amount[r + 1][c] += divide;
                amount[r + 1][c + 1] += divide;
                amount[r][c] = 1; 
        }
        return amount[query_row][query_glass];
    }
}