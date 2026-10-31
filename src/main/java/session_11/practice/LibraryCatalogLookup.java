package session_11.practice;

import java.util.Scanner;

public class LibraryCatalogLookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        String[] isbns = new String[n];
        String[] titles = new String[n];

        for (int i = 0; i < n; i++) {
            isbns[i] = sc.next();
            titles[i] = sc.next();
        }

        if (!sc.hasNext()) return;
        String targetIsbn = sc.next();

        int left = 0, right = n - 1;
        String foundTitle = "Not Found";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = isbns[mid].compareTo(targetIsbn);

            if (cmp == 0) {
                foundTitle = titles[mid];
                break;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(foundTitle);
    }
}
