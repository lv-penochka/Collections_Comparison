package performance;

import java.util.ArrayList;
import java.util.List;
/**
 Класс ArrayListResult представляет собой реализацию интерфейса ListPerformanceResult для ArrayList.
 **/
public class ArrayListResult implements ListPerformanceResult{
    List<Integer> numsArrayList=new ArrayList<>();
    int timesToAccess;

    private void fillArrayList() {
        numsArrayList.clear();
        for (int i =0; i < timesToAccess;i++){
            numsArrayList.add(i);
        }
    }

    /**
     Конструктор класса ArrayListResult.
     @param givenTimes количество операций доступа к элементам списка
     **/
    public ArrayListResult(int givenTimes){
        timesToAccess=givenTimes;
    }

    @Override
    public long AddPerformanceTime() {
        return measureTime(() -> {
            fillArrayList();
        });
    }

    @Override
    public long GetPerformanceTime() {
        fillArrayList();
        return measureTime(() -> {
            for (int i =0; i < timesToAccess;i++){
                numsArrayList.get(i);
            }
        });
    }

    @Override
    public long DeletePerformanceTime() {
        fillArrayList();
        return measureTime(() -> {
            for (int i = timesToAccess -1; i >= 0;i--){
                numsArrayList.remove(i);
            }
        });
    }
}
