public class Main {
    public static void main(String[] args) {
        SistemaDePedidos sistema = new SistemaDePedidos();

        sistema.adicionarPedido("Cliente A", "Produto 1", 50.0);
        sistema.adicionarPedido("Cliente B", "Produto 2", 30.0);
        sistema.adicionarPedido("Cliente C", "Produto 3", 70.0);

        // Simulando o processamento de um pedido

        for (int i = 0; i < 3; i++) {
            sistema.listarPedidos();

            sistema.processarPedido(i);

        }

        sistema.listarPedidos();

    }
}