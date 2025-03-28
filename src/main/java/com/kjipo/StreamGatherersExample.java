package com.kjipo;


import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Gatherer;
import java.util.stream.LongStream;

public class StreamGatherersExample {
    private static final SplittableRandom random = new SplittableRandom();


    private static void runExample() {
        List<DataRecord> dataRecords = LongStream.range(0, 50)
                .mapToObj(StreamGatherersExample::generateDataRecord)
                .toList();


        // TODO

//        dataRecords.stream()
//                .gather(createGatherer(DataRecord::value,
//                        10,
//                        Comparator.comparing(DataRecord::timeStamp)))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    }


//    private static <K> Gatherer<DataRecord, Map<K, List<DataRecord>>, List<DataRecord>> createGatherer(Function<? super DataRecord, ? extends K> keyExtractor,
//                                                                                                       int limit,
//                                                                                                       Comparator<? super DataRecord> comparator
//    ) {
//
//        return Gatherer.of(
//                HashMap::new,
//                (map, dataRecord, downstream) -> {
//                    K key = keyExtractor.apply(dataRecord);
//
//                }
//
//        );
//
//
//    }


    private static DataRecord generateDataRecord(long inputId) {
        SplittableRandom splittableRandom = random.split();
        return new DataRecord(inputId,
                "Datapoint_" + inputId,
                splittableRandom.nextInt(10),
                ZonedDateTime.now().minusDays(splittableRandom.nextLong(10 * 365)));
    }


    public static void main(String[] args) {
        runExample();

    }


}
