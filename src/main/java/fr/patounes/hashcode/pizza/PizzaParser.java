package fr.patounes.hashcode.pizza;

import fr.patounes.hashcode.pizza.data.Cell;
import fr.patounes.hashcode.pizza.data.Ingredient;
import fr.patounes.hashcode.pizza.data.Pizza;
import fr.patounes.hashcode.pizza.data.Slice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class PizzaParser {
    public static Pizza fromTextFile(String path) {
        int bufferSize = 8 * 1024;
        try {
            Pizza pizza;
            try (BufferedReader reader = new BufferedReader(new FileReader(path), bufferSize)) {
                String line = reader.readLine();
                String[] firstLine = line.split(" ");

                // first line: rows cols minCellsPerSlice maxCellsPerSlice
                int rows = Integer.parseInt(firstLine[0]);
                int cells = Integer.parseInt(firstLine[1]);
                int minCellsPerSlice = Integer.parseInt(firstLine[2]);
                int maxCellsPerSlice = Integer.parseInt(firstLine[3]);

                pizza = new Pizza(rows, cells, minCellsPerSlice, maxCellsPerSlice);

                // generate cells
                for (int i = 0; i < pizza.getNumRows(); i++) {
                    line = reader.readLine();
                    char[] ingredients = line.toCharArray();
                    for (int j = 0; j < pizza.getNumColumns(); j++) {
                        Ingredient ingredient;
                        if (ingredients[j] == 'T') {
                            ingredient = Ingredient.Tomato;
                        } else if (ingredients[j] == 'M') {
                            ingredient = Ingredient.Mushroom;
                        } else {
                            throw new Exception("Invalid ingredient '" + ingredients[j] + "'found at line " + i);
                        }
                        pizza.addCell(i, j, new Cell(i, j, ingredient));
                    }
                }
            }
            return pizza;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void printSlices(List<Slice> slices) {
        System.out.println(slices.size());
        for(Slice slice: slices) {
            String line = String.format("%d %d %d %d", slice.getStartX(), slice.getEndX(), slice.getStartY(), slice.getEndY());
            System.out.println(line);
        }
    }
}
