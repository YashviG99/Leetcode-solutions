class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        // Step 1: Add all rotten oranges to queue
        //         Count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Directions: Up, Down, Left, Right
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Step 2: Multi-Source BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Boundary check
                    if (newRow < 0 || newCol < 0 ||
                        newRow >= rows || newCol >= cols) {
                        continue;
                    }

                    // Ignore if not fresh
                    if (grid[newRow][newCol] != 1) {
                        continue;
                    }

                    // Rot the fresh orange
                    grid[newRow][newCol] = 2;
                    fresh--;

                    // Add newly rotten orange
                    queue.offer(new int[]{newRow, newCol});
                }
            }

            minutes++;
        }
        
        if (fresh == 0){ 
            return minutes; 
        } return -1;
    }
}