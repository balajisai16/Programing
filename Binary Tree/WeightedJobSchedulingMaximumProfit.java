import java.util.Arrays;
import java.util.Comparator;

class Job{
    int start;
    int end;
    int profit;
    Job(int start,int end,int profit){
        this.start= start;
        this.end = end;
        this.profit= profit;
    }
}

class FinishTimeComparator implements Comparator<Job>{

    @Override
    public int compare(Job arg0, Job arg1) {
        if(arg0.end <= arg1.end){
            return -1;
        }else{
            return 1;
        }
    }
    
}

/**
 * http://www.cs.princeton.edu/courses/archive/spr05/cos423/lectures/06dynamic-programming.pdf
 * Given set of jobs with start and end interval and profit, how to maximize profit such that 
 * jobs in subset do not overlap.
 */
public class WeightedJobSchedulingMaximumProfit {

    /**
     * Sort the jobs by finish time.
     * For every job find the first job which does not overlap with this job
     * and see if this job profit plus profit till last non overlapping job is greater
     * than profit till last job.
     * @param jobs
     * @return
     */
    public int maximum(Job[] jobs){
    	int t[] = new int[jobs.length];
    	FinishTimeComparator comparator = new FinishTimeComparator();
    	Arrays.sort(jobs,comparator);
    	int maxVal= Integer.MIN_VALUE;
    	for(int i=0;i<jobs.length;i++) {
    		t[i] = jobs[i].profit;
    	}
    	for(int i=1;i<jobs.length;i++) {
    		for(int j=0;j<i;j++) {
    			if(jobs[j].end <= jobs[i].start)
    				t[i] = Math.max(t[i], t[j] + jobs[i].profit);
    		}
    	}
    	
        for (int val : t) {
            if (maxVal < val) {
                maxVal = val;
            }
        }
        return maxVal;
    }
    
    public static void main(String args[]){
        Job jobs[] = new Job[6];
        jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,4);
        jobs[4] = new Job(5,8,11);
        jobs[5] = new Job(7,9,2);
        WeightedJobSchedulingMaximumProfit mp = new WeightedJobSchedulingMaximumProfit();
        System.out.println(mp.maximum(jobs));
    }
}