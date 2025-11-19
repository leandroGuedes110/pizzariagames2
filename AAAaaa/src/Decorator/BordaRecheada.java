package Decorator;

import FactoryMethod.Pizza;
import java.text.NumberFormat;
import java.util.Locale;

public class BordaRecheada extends PizzaDecorator {
    private static final double CUSTO = 7.50;
    private static final NumberFormat FORMATADOR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public BordaRecheada(Pizza pizzaDecorada) {
        super(pizzaDecorada);
    }

    @Override
    public double getCustoAdicional() {
        return CUSTO;
    }

    @Override
    public String getDescricao() {
        return pizzaDecorada.getDescricao() + ", Borda RECHEADA (" + FORMATADOR.format(CUSTO) + " de acréscimo)";
    }
}