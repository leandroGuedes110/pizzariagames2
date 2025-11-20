package FactoryMethod;

public class PizzaQueijo implements Pizza {
    @Override
    public String getDescricao() {
        return "Pizza de Queijo";
    }

    @Override
    public double getCusto() {
        return 40.00;
    }
}
