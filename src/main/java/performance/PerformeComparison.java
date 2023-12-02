package performance;
/**
 * Класс PerformeComparison представляет собой сравнение производительности
 * операций над списками ArrayList и LinkedList.
 */

public class PerformeComparison {
    public int givenNumber;
    public ListPerformanceResult performanceResultLinkedList;
    public ListPerformanceResult performanceResultArrayList;
    /**
     * Конструктор класса PerformeComparison.
     * @param givenNumber заданное количество элементов для операций
     */
    public PerformeComparison(int givenNumber){
        this.givenNumber=givenNumber;
        this.performanceResultLinkedList = new LinkedListResult(givenNumber);
        this.performanceResultArrayList = new ArrayListResult(givenNumber);
    }
    /**
     * Метод для вывода отформатированного времени выполнения операций
     * для сравнения LinkedList и ArrayList.
     */
    public void printFormatedTimeForComparison() {
        long addArrayListTime = performanceResultArrayList.AddPerformanceTime();
        long getArrayListTime = performanceResultArrayList.GetPerformanceTime();
        long delArrayListTime = performanceResultArrayList.DeletePerformanceTime();

        long addLinkedListTime = performanceResultLinkedList.AddPerformanceTime();
        long getLinkedListTime = performanceResultLinkedList.GetPerformanceTime();
        long delLinkedListTime = performanceResultLinkedList.DeletePerformanceTime();

        System.out.printf("%-10s | %-15s | %-20s | %-20s | %-20s\n", "Collection", "Number of items", "ms adding", "ms getting", "ms deleting");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-15d | %-20d | %-20d | %-20d\n", "ArrayList", givenNumber, addArrayListTime,getArrayListTime,delArrayListTime);
        System.out.printf("%-10s | %-15d | %-20d | %-20d | %-20d\n", "LinkedList", givenNumber,addLinkedListTime,getLinkedListTime, delLinkedListTime);
        System.out.print("\n\n");
    }


}
