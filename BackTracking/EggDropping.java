/*
	Given some number of floors and some number of eggs, what is the minimum number of attempts it will take to find out from which floor egg will break.
*/
public class EggDroping {

	public static void main(String[] args) {
		int numberOfFloors=6,numberOfEggs=2;
		int result = eggDropingUtil(numberOfFloors,numberOfEggs);
		System.out.println(result);
	}

	private static int eggDropingUtil(int floors, int eggs) {
			int temp[][] = new int[eggs + 1][floors + 1];
			for(int i = 1; i < floors +1; i++) {
				temp[1][i] = i;
			}
			for(int i=2;i<eggs + 1;i++) {
				for(int j=1;j<floors + 1;j++) {
					int min = Integer.MAX_VALUE;
					for(int k=1;k<=j;k++) {
						if(i > j) {
							temp[i][j] = temp[i-1][j];
						}
						else {
							int x = 1 + Math.max(temp[i-1][k-1],temp[i][j-k]);
							if(x < min)
							{
								min = x;
							}
						}
					}
					if( i <= j)
					{
						temp[i][j] = min;
						// System.out.println("i " + i + " j " + j);
					}
				}
			}
			return temp[eggs][floors];
	}

}