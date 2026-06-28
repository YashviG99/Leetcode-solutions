class Solution {
    public void setZeroes(int[][] matrix) {

        List<int[]> indices = new ArrayList<>();

        // Pass 1: Store all positions where value is 0
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    indices.add(new int[]{row, col});
                }
            }
        }

        // Pass 2: Make corresponding rows and columns zero
        for (int[] position : indices) {

            int row = position[0];
            int col = position[1];

            // Make entire row zero
            for (int j = 0; j < matrix[row].length; j++) {
                matrix[row][j] = 0;
            }

            // Make entire column zero
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}