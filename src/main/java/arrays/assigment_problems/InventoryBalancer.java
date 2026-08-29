public class InventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0, maxQty = -1, maxIndex = -1;
        String maxSection = "";
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQty) { maxQty = sectionA[i]; maxSection = "Section A"; maxIndex = i + 1; }
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQty) { maxQty = sectionB[i]; maxSection = "Section B"; maxIndex = i + 1; }
        }
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n", totalA, totalB, status, maxQty, maxSection, maxIndex);
    }
    public static void main(String[] args) {
        int[] secA = {20, 15, 30}, secB = {25, 10, 30};
        analyzeInventory(secA, secB);
    }
}
