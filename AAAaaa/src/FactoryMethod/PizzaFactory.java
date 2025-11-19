package FactoryMethod;

public class PizzaFactory {

    public static Pizza criarPizza(String tipo) {
        if (tipo == null) {
            return null;
        }
        if (tipo.equalsIgnoreCase("QUEIJO")) {
            return new PizzaQueijo();
        } else if (tipo.equalsIgnoreCase("CALABRESA")) {
            return new PizzaCalabresa();
        }

        else if (tipo.equalsIgnoreCase("FRANGÃO")) {
            return new PizzaFrangao();
        }
        return null;
    }
}