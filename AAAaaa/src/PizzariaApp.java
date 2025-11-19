package app;

import Decorator.BordaRecheada;
import Decorator.MassaFina;
import Decorator.MolhoExtra;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import FactoryMethod.Pizza;
import FactoryMethod.PizzaFactory;
// Importando todas as Strategy
import Strategy.DescontoDoProfessor10_10QueVaiMeDar10;
import Strategy.DescontoDaQuartaFeira;
import Strategy.PagamentoComDesconto;
import Strategy.PagamentoNormal;
import Strategy.PagamentoStrategy;

public class PizzariaApp {
    private static final NumberFormat FORMATADOR_MOEDA = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = null;
        String saborSelecionado = null;
        System.out.println("--- Pizzaria da UPE ---");


        while(pizza == null) {
            System.out.println("\nEscolha o sabor da sua pizza:");
            System.out.println("1. Queijo (" + FORMATADOR_MOEDA.format(40.00) + ")");
            System.out.println("2. Calabresa (" + FORMATADOR_MOEDA.format(45.00) + ")");
            System.out.println("3. Frangão (" + FORMATADOR_MOEDA.format(45.00) + ")"); // Novo sabor
            System.out.print("Selecione o número do sabor (1, 2 ou 3): ");
            String escolha = scanner.nextLine().trim();

            if (escolha.equals("1")) {
                saborSelecionado = "QUEIJO";
            } else if (escolha.equals("2")) {
                saborSelecionado = "CALABRESA";
            } else if (escolha.equals("3")) {
                saborSelecionado = "FRANGÃO";
            }

            if (saborSelecionado != null) {
                pizza = PizzaFactory.criarPizza(saborSelecionado);
            }

            if (pizza == null) {
                System.out.println("Opção inválida. Por favor, digite 1, 2 ou 3.");
            }
        }


        System.out.println("\nSabor da pizza selecionada: " + pizza.getDescricao());
        System.out.println("-> Custo Atual: " + FORMATADOR_MOEDA.format(pizza.getCusto()));
        System.out.println("\n--- Customização ---");


        while(true) {
            System.out.println("Opção: Massa Fina (" + FORMATADOR_MOEDA.format(2.00) + " de acréscimo)");
            System.out.print("Deseja Massa Fina? (Pressione Enter para Sim / 'N' para Não): ");
            String resposta = scanner.nextLine().trim();

            if (resposta.equalsIgnoreCase("S") || resposta.isEmpty()) {
                pizza = new MassaFina(pizza);
                System.out.println("-> Massa Fina adicionada. Custo Atual: " + FORMATADOR_MOEDA.format(pizza.getCusto()));
                break;
            }

            if (resposta.equalsIgnoreCase("N")) {
                break;
            }

            System.out.println("Opção inválida. Por favor, pressione Enter para Sim ou 'N' para Não.");
        }


        while(true) {
            System.out.println("Opção: Borda Recheada (" + FORMATADOR_MOEDA.format(7.50) + " de acréscimo)");
            System.out.print("Deseja Borda Recheada? (Pressione Enter para Sim / 'N' para Não): ");
            String resposta = scanner.nextLine().trim();

            if (resposta.equalsIgnoreCase("S") || resposta.isEmpty()) {
                pizza = new BordaRecheada(pizza);
                System.out.println("-> Borda Recheada adicionada. Custo Atual: " + FORMATADOR_MOEDA.format(pizza.getCusto()));
                break;
            }

            if (resposta.equalsIgnoreCase("N")) {
                break;
            }

            System.out.println("Opção inválida. Por favor, pressione Enter para Sim ou 'N' para Não.");
        }


        while(true) {
            System.out.println("Opção: Molho Extra (" + FORMATADOR_MOEDA.format(1.00) + " de acréscimo)");
            System.out.print("Deseja Molho Extra? (Pressione Enter para Sim / 'N' para Não): ");
            String resposta = scanner.nextLine().trim();

            if (resposta.equalsIgnoreCase("S") || resposta.isEmpty()) {
                pizza = new MolhoExtra(pizza);
                System.out.println("-> Molho Extra adicionado. Custo Atual: " + FORMATADOR_MOEDA.format(pizza.getCusto()));
                break;
            }

            if (resposta.equalsIgnoreCase("N")) {
                break;
            }

            System.out.println("Opção inválida. Por favor, pressione Enter para Sim ou 'N' para Não.");
        }

        double precoBruto = pizza.getCusto();
        System.out.println("\n--- Resumo do Pedido ---");
        System.out.println("Descrição Final: " + pizza.getDescricao());
        System.out.println("Preço Bruto Total (antes do pagamento): " + FORMATADOR_MOEDA.format(precoBruto));


        PagamentoStrategy estrategia = null;


        PagamentoStrategy normal = new PagamentoNormal();
        PagamentoStrategy sabadao = new PagamentoComDesconto(); // 20%
        PagamentoStrategy quarta = new DescontoDaQuartaFeira(); // 10%
        PagamentoStrategy professor = new DescontoDoProfessor10_10QueVaiMeDar10(); // 100%


        double precoNormal = normal.calcularPrecoFinal(precoBruto);
        double precoSabadao = sabadao.calcularPrecoFinal(precoBruto);
        double precoQuarta = quarta.calcularPrecoFinal(precoBruto);
        double precoProfessor = professor.calcularPrecoFinal(precoBruto);


        while(estrategia == null) {
            System.out.println("\n--- Forma de Pagamento ---");
            System.out.println("Preço Total SEM Desconto: " + FORMATADOR_MOEDA.format(precoBruto));
            System.out.println("\nOpções de Pagamento:");

            // Pré-apresentação dos descontos com preço final
            System.out.printf("1. %s | Preço Final: %s%n", normal.getNomeEstrategia(), FORMATADOR_MOEDA.format(precoNormal));
            System.out.printf("2. %s | Preço Final: %s%n", sabadao.getNomeEstrategia(), FORMATADOR_MOEDA.format(precoSabadao));
            System.out.printf("3. %s | Preço Final: %s%n", quarta.getNomeEstrategia(), FORMATADOR_MOEDA.format(precoQuarta));
            System.out.printf("4. %s | Preço Final: %s%n", professor.getNomeEstrategia(), FORMATADOR_MOEDA.format(precoProfessor));

            System.out.print("Escolha a forma de pagamento (1, 2, 3 ou 4): ");
            String escolhaPagamento = scanner.nextLine().trim();

            if (escolhaPagamento.equals("1")) {
                estrategia = normal;
            }
            else if (escolhaPagamento.equals("2")) {
                estrategia = sabadao;
            }
            else if (escolhaPagamento.equals("3")) {
                estrategia = quarta;
            }
            else if (escolhaPagamento.equals("4")) {
                estrategia = professor;
            }
            else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        double precoFinal = estrategia.calcularPrecoFinal(precoBruto);
        System.out.println("\n==================================");
        System.out.println("Seleção de Pagamento: " + estrategia.getNomeEstrategia());
        System.out.println("Preço Final: " + FORMATADOR_MOEDA.format(precoFinal));
        System.out.println("Obrigado pela preferência!");
        System.out.println("==================================");
        scanner.close();
    }
}