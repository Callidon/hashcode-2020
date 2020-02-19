package fr.patounes.hashcode.pizza;

import fr.patounes.hashcode.pizza.pojo.Pizza;
import fr.patounes.hashcode.pizza.pojo.Slice;

import java.util.LinkedList;
import java.util.List;

public interface PizzaCutter {
    List<Slice> cutPizza(Pizza pizza);
}
