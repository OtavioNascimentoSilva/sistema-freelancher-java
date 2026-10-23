import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Freelancer freelancer = new Freelancer();

        int opcao;

        do {
            System.out.println("\n===== CONTROLE DE FREELANCER =====");
            System.out.println("1 - Cadastrar serviço");
            System.out.println("2 - Relatório");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leia.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n===== BRINQUEDOS =====");
                    System.out.println("1 - Tobogã (R$ 20,00/h)");
                    System.out.println("2 - Tourinho (R$ 21,00/h)");
                    System.out.println("3 - Futebol de sabão (R$ 24,00/h)");
                    System.out.println("4 - Cama elástica/Piscina (R$ 19,90/h)");
                    System.out.println("5 - Touro mecânico (R$ 25,00/h)");
                    System.out.print("Escolha o brinquedo: ");

                    int b = leia.nextInt();

                    String brinquedo = "";
                    double valorHora = 0;

                    switch (b) {
                        case 1:
                            brinquedo = "Tobogã";
                            valorHora = 20.00;
                            break;
                        case 2:
                            brinquedo = "Tourinho";
                            valorHora = 21.00;
                            break;
                        case 3:
                            brinquedo = "Futebol de sabão";
                            valorHora = 24.00;
                            break;
                        case 4:
                            brinquedo = "Cama elástica/Piscina";
                            valorHora = 19.90;
                            break;
                        case 5:
                            brinquedo = "Touro mecânico";
                            valorHora = 25.00;
                            break;
                        default:
                            System.out.println("Brinquedo inválido!");
                            break;
                    }

                    if (b < 1 || b > 5) {
                        break;
                    }

                    System.out.print("Quantas horas trabalhou? ");
                    double horas = leia.nextDouble();

                    System.out.print("Hora de início (0 a 23): ");
                    int hora = leia.nextInt();

                    System.out.print("Minutos (0 a 59): ");
                    int minuto = leia.nextInt();

                    System.out.print("Transporte de ida e volta (R$): ");
                    double transporte = leia.nextDouble();

                    if (horas <= 0 || transporte < 0
                            || hora < 0 || hora > 23
                            || minuto < 0 || minuto > 59) {
                        System.out.println("Dados inválidos!");
                        break;
                    }

                    LocalTime horario = LocalTime.of(hora, minuto);
                    Servico servico;

                    if (hora >= 22) {
                        servico = new ServicoNoturno(
                                brinquedo, horas, valorHora,
                                transporte, horario);
                    } else {
                        servico = new Servico(
                                brinquedo, horas, valorHora,
                                transporte, horario);
                    }

                    freelancer.cadastrar(servico);

                    System.out.println("\nServiço cadastrado!");
                    System.out.printf("Total previsto: R$ %.2f%n",
                            servico.calcularTotal());
                    break;

                case 2:
                    freelancer.relatorio();
                    break;

                case 3:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 3);

        leia.close();
    }
}