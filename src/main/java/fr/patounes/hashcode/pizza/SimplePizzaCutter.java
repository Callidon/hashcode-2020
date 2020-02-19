package fr.patounes.hashcode.pizza;

import fr.patounes.hashcode.pizza.data.Pizza;
import fr.patounes.hashcode.pizza.data.Slice;

import java.util.LinkedList;
import java.util.List;

public class SimplePizzaCutter implements PizzaCutter {
    @Override
    public List<Slice> cutPizza(Pizza pizza) {
        List<Slice> slices = new LinkedList<>();
        // make slice of size 1
        for(int i = 0; i < pizza.getNumRows(); i++) {
            for (int j = 0; j < pizza.getNumColumns(); j++) {
                slices.add(new Slice(i, i, j, j));
            }
        }
        return slices;
    }
}
