package fr.patounes.hashcode.pizza;

import fr.patounes.hashcode.pizza.pojo.Pizza;
import fr.patounes.hashcode.pizza.pojo.Slice;
import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "pizza-cutter", description= "cuts some pizzas")
public class MainPizza implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "Path to the input pizza file")
    private String filePath = "src/main/resources/pizza.txt";

    @Override
    public Integer call() throws Exception {
        // read input
        Pizza pizza = PizzaParser.fromTextFile(filePath);
        //System.out.println(pizza.toString());

        // solve problem
        PizzaCutter cutter = new SimplePizzaCutter();
        List<Slice> slices = cutter.cutPizza(pizza);

        // print solutions
        SolutionWriter.printSlices(slices);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new MainPizza()).execute(args);
        System.exit(exitCode);
    }
}
