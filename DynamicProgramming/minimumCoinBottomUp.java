// minimumCoinBottomUp Approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int min[] = new int[amount+1];
        int pos[] = new int[amount+1];
        min[0] = 0;
        pos[0] = -1;
        for(int i=1;i<min.length;i++) {
           min[i] = Integer.MAX_VALUE-1;
           pos[i] = -1;
        }
        
        for(int i=0;i<coins.length;i++) {
            for(int j=1;j<min.length;j++) {
                if(j  >= coins[i])
                {
                     min[j] = Math.min(min[j], 1+min[j - coins[i]]); 
                     pos[j] = i;
                     System.out.println("min[j] "+ min[j] +" j "+ j + " coin " + coins[i]) ;
                }  
        }
      return (min[min.length-1] < 0 || min[min.length-1] == Integer.MAX_VALUE )?-1: min[min.length-1];  
    }
}