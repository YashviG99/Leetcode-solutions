class Solution {

    public int scoreOfParentheses(String s) {
        return score(s);
    }

    private int score(String s) {

        // Base case
        if (s.equals("()"))
            return 1;

        int balance = 0;

        // Find first balanced substring
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                balance++;
            else
                balance--;

            if (balance == 0) {

                // entire string is closed by one pair
                if (i == s.length() - 1)
                    return 2 * score(s.substring(1, s.length() - 1));

                // split in two balanced parts
                return score(s.substring(0, i + 1))
                     + score(s.substring(i + 1));
            }
        }

        return 0;
    }
}