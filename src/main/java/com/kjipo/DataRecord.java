package com.kjipo;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.IntStream;


public record DataRecord(UUID uuid, String data, int value, ZonedDateTime timeStamp) {

    public static DataRecord createRandomDataRecord() {
        return new DataRecord(UUID.randomUUID(),
                "Test record",
                1,
                ZonedDateTime.now());
    }

    public static Collection<DataRecord> createRandomDataRecords(int numberOfRecords) {
        return IntStream.range(0, numberOfRecords)
                .mapToObj(_ -> createRandomDataRecord())
                .toList();
    }

}
