import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SistemaDePedidosComThreads {
    private List<Pedido> pedidos;
    private ExecutorService executor;

    public SistemaDePedidosComThreads(int numThreads) {
        pedidos = new ArrayList<>();
        executor = Executors.newFixedThreadPool(numThreads);
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
        System.out.println();
    }

    public void processarPedidosConcorrentemente() {
        for (Pedido pedido : pedidos) {
            if (!pedido.isProcessado()) {
                executor.execute(() -> {
                    processarPedido(pedido);
                });
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            System.out.println("Aguardando o término das threads...");
        }
    }


    private void processarPedido(Pedido pedido) {
        System.out.println("Processando pedido de " + pedido.getCliente() + ": " + pedido.getItem());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pedido.processar();
        System.out.println("Pedido processado: " + pedido.getItem());
    }
}
