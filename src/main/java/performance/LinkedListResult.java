package performance;

import java.util.LinkedList;
import java.util.List;
import java.time.Duration;
import java.time.Instant;
/**
 Класс LinkedListResult представляет собой реализацию интерфейса ListPerformanceResult для LinkedList.
 **/
public class LinkedListResult implements ListPerformanceResult{
    List<Integer> numsLinkedList=new LinkedList<>();
    int timesToAccess;

    private void fillLinkedList() {
        numsLinkedList.clear();
        for (int i =0; i < timesToAccess;i++){
            numsLinkedList.add(i);
        }
    }

    /**
    Конструктор класса LinkedListResult.
    @param givenTimes количество операций доступа к элементам списка
     **/
    public LinkedListResult(int givenTimes){
        timesToAccess=givenTimes;
    }

    @Override
    public long AddPerformanceTime() {
        return measureTime(() -> {
            fillLinkedList();
        });
    }

    @Override
    public long GetPerformanceTime() {
        fillLinkedList();
        return measureTime(() -> {
            for (int i = 0; i < timesToAccess; i++) {
                numsLinkedList.get(i);
            }
        });
    }

    @Override
    public long DeletePerformanceTime() {
        fillLinkedList();
        return measureTime(() -> {
            for (int i = timesToAccess -1; i >= 0;i--){
                numsLinkedList.remove(i);
            }
        });
    }
}
