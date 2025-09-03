import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

class Medicamento {
    private String nome;
    private double preco;

    public Medicamento(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

public class Farm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Lista de medicamentos
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(new Medicamento("Dipirona Monoidratada 500mg 10 comprimidos", 5.30));
        medicamentos.add(new Medicamento("Ibuprofeno 600mg 20 comprimidos", 6.60));
        medicamentos.add(new Medicamento("Teste de Gravidez Clearblue Digital", 55.20));
        medicamentos.add(new Medicamento("Benegrip Multi Sabor Frutas Vermelhas 240ml", 30.00));

        while (true) {
            System.out.println("\n=== FARMÁCIA ===");
            System.out.println("1 - Compra de Medicamentos");
            System.out.println("2 - Consulta com Farmacêutico");
            System.out.println("3 - Retirada de Remédio com Receita");
            System.out.println("0 - Sair");
            System.out.print("O que você deseja hoje? Insira o número correspondente ao serviço: ");
            int opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("=== COMPRA DE MEDICAMENTOS ===");
                    for (int i = 0; i < medicamentos.size(); i++) {
                        Medicamento m = medicamentos.get(i);
                        System.out.println((i + 1) + " - " + m.getNome() + " | R$" + String.format("%.2f", m.getPreco()));
                    }

                    System.out.print("Escolha um medicamento: ");
                    int escolha = sc.nextInt();

                    if (escolha >= 1 && escolha <= medicamentos.size()) {
                        Medicamento escolhido = medicamentos.get(escolha - 1);
                        System.out.print("Quantos você deseja? ");
                        int quantidade = sc.nextInt();
                        double total = quantidade * escolhido.getPreco();
                        System.out.println("Valor da compra: R$" + String.format("%.2f", total));
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 2:
                    System.out.println("=== CONSULTA COM FARMACÊUTICO ===");
                    System.out.println("1 - Ana Beatriz");
                    System.out.println("2 - Camilla Paula");
                    System.out.println("3 - Maria Beatriz");
                    System.out.println("4 - Pedro Oliveira");
                    System.out.print("Escolha um Farmacêutico: ");
                    int opcComp2 = sc.nextInt();

                    if (opcComp2 >= 1 && opcComp2 <= 4) {
                        int min = 71000000;
                        int max = 99999999;
                        int tel = random.nextInt(max - min + 1) + min;

                        int min2 = 8;
                        int max2 = 17;
                        int hor = random.nextInt(max2 - min2 + 1) + min2;
                        System.out.println("Farmacêutico disponível!");
                        System.out.println("Número do Farmacêutico: (81)9" + tel);
                        System.out.println("Hora da Consulta: " + hor + ":00");
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 3:
                    boolean result = random.nextBoolean();
                    System.out.println("=== RETIRADA DE REMÉDIO POR RECEITA ===");
                    System.out.print("Insira o remédio que deseja: ");
                    String word = sc.next();
                    if (result) {
                        System.out.println(word + " está disponível! Receba na farmácia e obrigado pelo uso!");
                    } else {
                        System.out.println(word + " não está disponível! Tente novamente outro dia!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema... Obrigado!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
