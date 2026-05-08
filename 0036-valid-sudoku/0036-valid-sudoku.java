class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){

                char n = board[r][c];

                if (n == '.') continue;

                String row = "row" + r + n;
                String col = "col" + c + n;
                String box = "box" + (r/3*3 + c/3) + n;

                if (set.contains(row) || set.contains(col) || set.contains(box)){
                    return false;
                }

                set.add(row);
                set.add(col);
                set.add(box);

            }
        }
        
        return true;
    }
}