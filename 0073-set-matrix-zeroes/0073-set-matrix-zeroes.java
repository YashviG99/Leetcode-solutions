class Solution {
    public void setZeroes(int[][] matrix) {

        List<int[]> indices = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    indices.add(new int[]{row, col});
                }
            }
        }
        for (int[] position : indices) {

            int row = position[0];
            int col = position[1];

            for (int j = 0; j < matrix[row].length; j++) {
                matrix[row][j] = 0;
            }
            
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}