import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor do cartão: ");
        double limite = scanner.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);
        int sair = 1;
        while (sair != 0) {
            scanner.nextLine();
            System.out.println("Digite a descrição da compra:");
            String descricao = scanner.nextLine();

            System.out.println("Digite o valor da compra: ");
            double valor = scanner.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean CompraRealizada = cartao.lancaCompra(compra);
            if (CompraRealizada) {
                System.out.println("Compra realizada com sucesso!");
                System.out.println("digite 0 para sair da compra ou  1 para continuar!" );
                sair = scanner.nextInt();

            }
            else {
                System.out.println("Saldo insuficiente!");
                System.out.println("digite 0 para sair da compra ou  1 para continuar!" );
                sair = scanner.nextInt();

            }
            System.out.println("***********************");
            System.out.println("COMPRAS REALIZADAS:\n");

            for (Compra c : cartao.getCompras()) {
                System.out.println(c.getDescricao() + ": " + c.getValor());

            }
            System.out.println("\n***********************");

            System.out.println("\nSaldo do cartão: " +cartao.getSaldo());

        }
    }
}