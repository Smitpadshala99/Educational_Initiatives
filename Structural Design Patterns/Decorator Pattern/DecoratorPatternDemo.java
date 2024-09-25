// Component Interface
interface Pizza {
    String getDescription();
    double getCost();
}

// Concrete Component
class BasicPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}

// Decorator Class
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double getCost() {
        return pizza.getCost();
    }
}

// Concrete Decorator: Cheese
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.50;
    }
}

// Main
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizza();
        System.out.println(pizza.getDescription() + " Cost: $" + pizza.getCost());

        pizza = new CheeseDecorator(pizza);
        System.out.println(pizza.getDescription() + " Cost: $" + pizza.getCost());
    }
}
