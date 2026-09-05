import java.util.Arrays;
class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;
    double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.compositeScore = (cgpa * 10) + (codingScore / 2.0);
    }
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore, this.compositeScore);
    }
}
public class PlacementEngine {
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }
    static String shortListAndRank(Candidate[] candidates) {
        Candidate[] valid = new Candidate[candidates.length];
        int count = 0;
        for (int i = 0; i < candidates.length; i++) {
            Candidate c = candidates[i];
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                valid[count++] = c;
            }
        }
        Candidate[] shortlisted = Arrays.copyOf(valid, count);
        Arrays.sort(shortlisted);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append((i + 1)).append(". ").append(shortlisted[i].name)
              .append(" (").append(shortlisted[i].compositeScore).append(")");
            if (i < shortlisted.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortListAndRank(candidates));
    }
}
