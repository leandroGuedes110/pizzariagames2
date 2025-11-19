package Decorator;

import FactoryMethod.Pizza;

public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizzaDecorada;

    public PizzaDecorator(Pizza pizzaDecorada) {
        this.pizzaDecorada = pizzaDecorada;
    }


    public abstract double getCustoAdicional();


    @Override
    public String getDescricao() {
        return pizzaDecorada.getDescricao();
    }


    @Override
    public double getCusto() {
        return pizzaDecorada.getCusto() + getCustoAdicional();
    }
}