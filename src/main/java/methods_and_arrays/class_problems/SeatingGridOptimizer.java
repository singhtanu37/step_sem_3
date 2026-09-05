public class SeatingGridOptimizer {
    static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        double sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        return sum / row.length;
    }
    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String classification = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";
            result.append("Row ").append(i).append(": ").append(classification);
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        int[][] scores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(scores, 60));
    }
}
