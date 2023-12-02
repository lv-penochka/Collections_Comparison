package performance;

public class Main {
    public static void main(String[] args) {
        int timesToAccess=10000;
        PerformeComparison performance = new PerformeComparison(timesToAccess);
        performance.printFormatedTimeForComparison();
    }
}
