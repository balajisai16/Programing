import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Combinations {

	public List<String> genrate(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        // permuteUtil(str, count, result, 0, resultList);
        computeUtil(str,count,result,0,0);
        return resultList;
    }
	
	private void computeUtil(char[] str, int[] count, char[] result, int level, int pos) {
		for(int i=0;i<level;i++) {
        	System.out.print(result[i]);
        }
		System.out.println();
		for(int i=pos;i<str.length;i++) {
			if(count[i] == 0)
				continue;
			result[level] = str[i];
			count[i]--;
			computeUtil(str, count, result, level+1, i);
			count[i]++;
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations cm = new Combinations();
		cm.genrate("ABC".toCharArray());
	}

}