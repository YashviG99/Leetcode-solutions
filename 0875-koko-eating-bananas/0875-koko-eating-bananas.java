class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Find the maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // Binary Search
        while (low < high) {

            int mid = low + (high - low) / 2;

            // Check if Koko can finish at this speed
            if (canEatInTime(piles, h, mid)) {
                high = mid;      // Try smaller speed
            } else {
                low = mid + 1;   // Need bigger speed
            }
        }

        return low;
    }

    // Returns true if Koko can finish all bananas within h hours
    private boolean canEatInTime(int[] piles, int h, int speed) {

        int hours = 0;

        for (int pile : piles) {

            hours += (int) Math.ceil((double) pile / speed);

        }

        return hours <= h;// return true or false
    }
}