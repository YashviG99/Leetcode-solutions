class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // Find search range
        for (int w : weights) {
            low = Math.max(low, w); // maximum weight
            high += w;              // sum of weights
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                high = mid - 1;   // try smaller capacity
            } else {
                low = mid + 1;    // need larger capacity
            }
        }

        return low;
    }

    boolean canShip(int[] weights, int days, int capacity) {

        int day = 1;
        int load = 0;

        for (int w : weights) {

            if (load + w > capacity) {
                day++;
                load = 0;
            }

            load += w;
        }

        return day <= days;
    }
}