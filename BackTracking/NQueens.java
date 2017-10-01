/*
  The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
  Given an integer n, return all distinct solutions to the n-queens puzzle.

  Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

  For example,
  There exist two distinct solutions to the 4-queens puzzle:

  [
   [".Q..",  // Solution 1
    "...Q",
    "Q...",
    "..Q."],

   ["..Q.",  // Solution 2
    "Q...",
    "...Q",
    ".Q.."]
  ]
*/

class Solution {
    class Positions {
        int col,row;
        public Positions(int row1,int col1) {
            col = col1;
            row = row1;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n == 0)
            return result;
        Positions positions[] = new Positions[n];
        result = nQueens(0,positions,result,n);
        return result;
    }
    
    public List<List<String>> nQueens(int row, Positions[] positions, List<List<String>> result, int n) {
        if(n == row) {
           StringBuffer buffer = new StringBuffer();
           List<String> temp = new ArrayList<>();
           for(Positions pos: positions) {
               for(int i=0;i<n;i++) {
                   if(pos.col == i)
                       buffer.append("Q");
                   else
                       buffer.append(".");
               }
               temp.add(buffer.toString());
               buffer = new StringBuffer();
           }
            result.add(temp);
            return null;
        }
        for(int col = 0; col < n; col++) {
            boolean isFound = true;
            for(int p = 0; p < row; p++) {
                if(positions[p].col == col || positions[p].col - positions[p].row == col - row || 
                   positions[p].col + positions[p].row == col + row) {
                    isFound = false;
                    break;
                }
            }
            if(isFound) {
                positions[row] = new Positions(row,col);
                nQueens(row+1,positions,result,n);
            }
        }
        return result;
    }
}