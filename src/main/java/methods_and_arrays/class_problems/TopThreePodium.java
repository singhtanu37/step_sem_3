import java.util.Arrays;
public class TopThreePodium {
    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > first) {
                third = second;
                second = first;
                first = scores[i];
            } else if (scores[i] > second && scores[i] != first) {
                third = second;
                second = scores[i];
            } else if (scores[i] > third && scores[i] != second && scores[i] != first) {
                third = scores[i];
            }
        }
        return new int[]{first, second, third};
    }
    public static void main(String[] args) {
        int[] result = findTopThreeScores(new int[]{45, 82, 79, 90, 33, 90, 61});
        System.out.println(Arrays.toString(result));
    }
}
