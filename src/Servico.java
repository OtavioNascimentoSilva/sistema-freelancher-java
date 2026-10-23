import java.time.LocalTime;

public class Servico {
    private String brinquedo;
    private double horas;
    private double valorHora;
    private double transporte;
    private LocalTime horario;

    public Servico(String brinquedo, double horas,
                   double valorHora, double transporte,
                   LocalTime horario) {
        this.brinquedo = brinquedo;
        this.horas = horas;
        this.valorHora = valorHora;
        this.transporte = transporte;
        this.horario = horario;
    }

    public String getBrinquedo() {
        return brinquedo;
    }

    public double getHoras() {
        return horas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public double getTransporte() {
        return transporte;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public double calcularServico() {
        return horas * valorHora;
    }

    public double calcularAdicional() {
        return 0;
    }

    public double calcularTotal() {
        return calcularServico() + calcularAdicional()
                + transporte;
    }

    public void mostrar() {
        System.out.println("\nBrinquedo: " + brinquedo);
        System.out.println("Horas trabalhadas: " + horas);
        System.out.println("Horário: " + horario);

        System.out.printf("Valor do serviço: R$ %.2f%n",
                calcularServico());
        System.out.printf("Transporte: R$ %.2f%n", transporte);
        System.out.printf("Adicional noturno: R$ %.2f%n",
                calcularAdicional());
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
    }
}