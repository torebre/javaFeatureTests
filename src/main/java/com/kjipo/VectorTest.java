package com.kjipo;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorOperators;

import java.util.stream.IntStream;

public class VectorTest {


    private static void vectorTest() {
        var species = IntVector.SPECIES_PREFERRED;
        var intArray = IntStream.range(0, 200).toArray();
        var intArray2 = IntStream.range(0, 200).toArray();

        var finalResult = new int[200];
        var sumVector = IntVector.zero(species);

        for (int i = 0; i < intArray.length; i += species.length()) {
            // Not all CPUs supports masks
            var mask = species.indexInRange(i, intArray.length);
            var vector = IntVector.fromArray(species, intArray, i, mask);
            var vector2 = IntVector.fromArray(species, intArray2, i, mask);

            var result = vector.add(vector2, mask);
            result.intoArray(finalResult, i, mask);

            sumVector = sumVector.add(result);
        }

        IntStream.of(finalResult).boxed().map(value -> value + ", ").forEach(System.out::print);
        System.out.println();

        var sum = sumVector.reduceLanes(VectorOperators.ADD);
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        vectorTest();

    }

}
