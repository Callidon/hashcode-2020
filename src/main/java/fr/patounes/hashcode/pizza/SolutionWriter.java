package fr.patounes.hashcode.pizza;

import fr.patounes.hashcode.pizza.pojo.Slice;

import java.util.List;

public class SolutionWriter {
    public static void printSlices(List<Slice> slices) {
        System.out.println(slices.size());
        for(Slice slice: slices) {
            String line = String.format("%d %d %d %d", slice.getStartX(), slice.getEndX(), slice.getStartY(), slice.getEndY());
            System.out.println(line);
        }
    }
}
