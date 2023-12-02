package performance;

import java.time.Duration;
import java.time.Instant;

public interface ListPerformanceResult {
    /**
     Метод для измерения производительности операции добавления элементов.
     @return время выполнения операции в миллисекундах
     **/
    long AddPerformanceTime();
    /**
     Метод для измерения производительности операции доступа к элементам.
     @return время выполнения операции в миллисекундах
     **/
    long GetPerformanceTime();
       /**
    Метод для измерения производительности операции удаления элементов.
    @return время выполнения операции в миллисекундах
     **/
    long DeletePerformanceTime();

    default long measureTime(Runnable original) {
        Instant startTime,endTime;
        startTime=Instant.now();
        original.run();
        endTime=Instant.now();
        return Duration.between(startTime,endTime).toMillis();
    }
}
