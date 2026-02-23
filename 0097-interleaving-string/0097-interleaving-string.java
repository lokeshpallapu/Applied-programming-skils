class Solution {
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return back(0, 0, s1, s2, s3);
    }

    public boolean back(int i, int j, String s1, String s2, String s3){
        if(i == s1.length() && j == s2.length()) return true;
        if (dp[i][j] != null) return dp[i][j];

        int k = i + j;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if(back(i+1, j, s1, s2, s3)) return dp[i][j] = true;
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if(back(i, j+1, s1, s2, s3)) return dp[i][j] = true;
        }

        return dp[i][j] = false;
    }
}