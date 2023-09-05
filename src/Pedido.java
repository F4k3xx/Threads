public class Pedido {
    private String cliente;
    private String item;
    private double valor;
    private boolean processado;

    public Pedido(String cliente, String item, double valor) {
        this.cliente = cliente;
        this.item = item;
        this.valor = valor;
        this.processado = false;
    }

    public String getCliente() {
        return cliente;
    }

    public String getItem() {
        return item;
    }

    public double getValor() {
        return valor;
    }

    public boolean isProcessado() {
        return processado;
    }

    public void processar() {
        this.processado = true;
    }

    @Override
    public String toString() {
        return "Pedido de " + cliente + ": " + item + " (R$" + valor + ")" + (processado ? " - Processado" : " - Pendente");
    }
}
