public class ServicoNoturno extends Servico {

    public ServicoNoturno(String brinquedo, double horas,
                          double valorHora, double transporte,
                          java.time.LocalTime horario) {
        super(brinquedo, horas, valorHora, transporte, horario);
    }

    @Override
    public double calcularAdicional() {
        return calcularServico() * 0.05;
    }
}