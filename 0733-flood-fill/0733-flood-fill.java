class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int Color) {
        int oldColor = image[sr][sc];

        if (oldColor == Color) {
            return image;
        }

        dfs(image, sr, sc, oldColor, Color);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int oldColor, int Color){
        if (row < 0 || col < 0 ||
            row >= image.length || col >= image[0].length) {
            return;
        }

         if (image[row][col] != oldColor) {
            return;
        }

        image[row][col] = Color;

        dfs(image, row - 1, col, oldColor, Color); // Up
        dfs(image, row + 1, col, oldColor, Color); // Down
        dfs(image, row, col - 1, oldColor, Color); // Left
        dfs(image, row, col + 1, oldColor, Color); // Right
    }
}