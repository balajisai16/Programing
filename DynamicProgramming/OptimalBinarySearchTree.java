package problem;

public class OptimalBinarySearchTree {
	
	public static void main(String args[]) {
		int arr[] = {10,12};
		int freq[] = {34,50};
		int result = findCost(arr,freq);
		System.out.println(result);
	}

	private static int findCost(int[] arr, int[] freq) {
		int temp[][] = new int[arr.length][arr.length];
		for(int l=0; l<arr.length;l++) {
			int j=l;
			for(int i=0;i< arr.length-l;i++) {
				if(i == j)
				{
					temp[i][j] = freq[i];
				}
				else
				{
					temp[i][j] = Integer.MAX_VALUE;
					int sum = 0;
					for(int k=i;k<j+1;k++) {
						sum +=freq[k];
					}
					for(int k=i;k<j+1;k++) {
						int sum1 = sum;
						if(k == i)
							sum1+=temp[k+1][j];
						else if(k == j)
							sum1+=temp[i][j-1];
						else
							sum1+=temp[i][k-1]+temp[k+1][j];
						if(sum1 < temp[i][j])
							temp[i][j] = sum1;
					}
				}
				j++;
			}
		}
		return temp[0][arr.length-1];
	}

}
