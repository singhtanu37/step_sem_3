package encapsulation.class_problems;

public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public void changeCode(String oldCode, String newCode) {
        if (this.combinationCode.equals(oldCode)) {
            this.combinationCode = newCode;
            System.out.println("L.changeCode(\"" + oldCode + "\", \"" + newCode + "\") -> success");
        } else {
            System.out.println("L.changeCode(\"" + oldCode + "\", \"" + newCode + "\") -> rejected, code is still \"" + this.combinationCode + "\"");
        }
    }

    public static void main(String[] args) {
        Locker L = new Locker(101, "1234");
        L.changeCode("1234", "5678");
        L.changeCode("0000", "9999");
    }
}
