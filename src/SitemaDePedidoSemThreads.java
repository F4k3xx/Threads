import java.util.ArrayList;
import java.util.List;

public class SitemaDePedidoSemThreads {
    private List<Pedido> pedidos;

    public SitemaDePedidoSemThreads() {
        pedidos = new ArrayList<>();
    }

    public void adicionarPedido(String cliente, String item, double valor) {
        Pedido pedido = new Pedido(cliente, item, valor);
        pedidos.add(pedido);
    }

    public void listarPedidos() {
        System.out.println("Lista de Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    public void processarPedido(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            if (!pedido.isProcessado()) {
                pedido.processar();
                System.out.println("Pedido processado: " + pedido.getItem());
            } else {
                System.out.println("Este pedido já foi processado anteriormente.");
            }
        } else {
            System.out.println("Índice de pedido inválido.");
        }
    }

}
