public class Main {

    private static double pSemThreads;
    private static double pComThreads;

    public static void chamarSistemaDePedidosSemThreads() {
        long startTime = System.nanoTime();

        SitemaDePedidoSemThreads sistema = new SitemaDePedidoSemThreads();

        sistema.adicionarPedido("Cliente A", "Produto 1", 50.0);
        sistema.adicionarPedido("Cliente B", "Produto 2", 30.0);
        sistema.adicionarPedido("Cliente C", "Produto 3", 70.0);
        sistema.adicionarPedido("Cliente D", "Produto 4", 70.0);
        sistema.adicionarPedido("Cliente E", "Produto 5", 70.0);
        sistema.adicionarPedido("Cliente F", "Produto 6", 70.0);
        sistema.adicionarPedido("Cliente G", "Produto 7", 70.0);
        sistema.adicionarPedido("Cliente H", "Produto 8", 70.0);
        sistema.adicionarPedido("Cliente I", "Produto 9", 70.0);
        sistema.adicionarPedido("Cliente J", "Produto 10", 70.0);

        for (int i = 0; i < 10; i++) {
            sistema.listarPedidos();

            sistema.processarPedido(i);

        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        pSemThreads = duration;
    }

    public static void chamarSistemaDePedidoSemThreads() {
        long startTime = System.nanoTime();

        SistemaDePedidosComThreads sistema = new SistemaDePedidosComThreads(2);

        sistema.adicionarPedido("Cliente A", "Produto 1", 50.0);
        sistema.adicionarPedido("Cliente B", "Produto 2", 30.0);
        sistema.adicionarPedido("Cliente C", "Produto 3", 70.0);
        sistema.adicionarPedido("Cliente D", "Produto 4", 70.0);
        sistema.adicionarPedido("Cliente E", "Produto 5", 70.0);
        sistema.adicionarPedido("Cliente F", "Produto 6", 70.0);
        sistema.adicionarPedido("Cliente G", "Produto 7", 70.0);
        sistema.adicionarPedido("Cliente H", "Produto 8", 70.0);
        sistema.adicionarPedido("Cliente I", "Produto 9", 70.0);
        sistema.adicionarPedido("Cliente J", "Produto 10", 70.0);

        sistema.listarPedidos();

        sistema.processarPedidosConcorrentemente();

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        pComThreads = duration;
    }

    public static void main(String[] args) {

        

        System.out.println();
        System.out.println();

        System.out.println("==============================");
        System.out.println("Sistema de Pedidos Com Threads");
        System.out.println("==============================");
        chamarSistemaDePedidoSemThreads();

        System.out.println();
        System.out.println("Tempo de execução (com threads): " + pSemThreads + " nanossegundos");
        System.out.println("Tempo de execução (sem threads): " + pComThreads + " nanossegundos");

    }

}