//452. Minimum Number of Arrows to Burst Balloons
//Time complexity O(nlog(n)) because of the sorting algorithm but this could be different
import java.util.Arrays;
class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int arrowCount = 0;
        int[] ballon = new int[2];

        for(int i = 0; i < points.length;i++){
            if(i == 0){
                ballon[0] = points[i][0];
                ballon[1] = points[i][1];
                arrowCount++;
            }
            else if(ballon[0] <= points[i][1] && ballon[1] >= points[i][0]){
                continue;
            }
            else{
                ballon[0] = points[i][0];
                ballon[1] = points[i][1];
                arrowCount++; 
            }
        }
        return arrowCount;
    }
}
