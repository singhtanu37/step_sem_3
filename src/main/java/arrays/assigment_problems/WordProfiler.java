public class WordProfiler {
    public static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortW = 0, medium = 0, longW = 0;
        for (String word : words) {
            int len = word.replaceAll("[^a-zA-Z]", "").length(); 
            if (len >= 1 && len <= 4) shortW++;
            else if (len >= 5 && len <= 8) medium++;
            else if (len >= 9) longW++;
        }
        System.out.println("Short: " + shortW + " | Medium: " + medium + " | Long: " + longW);
    }
    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
