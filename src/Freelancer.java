import java.util.ArrayList;

public class Freelancer {
    private ArrayList<Servico> servicos = new ArrayList<>();

    public void cadastrar(Servico servico) {
        servicos.add(servico);
    }

    public void relatorio() {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
            return;
        }

        double totalServicos = 0;
        double totalTransporte = 0;
        double totalAdicional = 0;
        double totalGeral = 0;

        System.out.println("\n===== RELATÓRIO GERAL =====");

        for (Servico s : servicos) {
            s.mostrar();

            totalServicos += s.calcularServico();
            totalTransporte += s.getTransporte();
            totalAdicional += s.calcularAdicional();
            totalGeral += s.calcularTotal();
        }

        System.out.println("\n===== RESUMO =====");
        System.out.println("Quantidade de serviços: " + servicos.size());

        System.out.printf("Serviços: R$ %.2f%n", totalServicos);
        System.out.printf("Transporte: R$ %.2f%n", totalTransporte);
        System.out.printf("Adicional noturno: R$ %.2f%n", totalAdicional);
        System.out.printf("TOTAL A RECEBER: R$ %.2f%n", totalGeral);
    }
}