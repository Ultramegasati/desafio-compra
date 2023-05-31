package br.com.compras;

import br.com.compras.cartao.CartaoDeCredito;
import br.com.compras.compra.Compra;

import java.util.Collections;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");

        double limite = teclado.nextDouble();

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite);


        int sair = 1;
        while (sair != 0){

            System.out.println("Digite descrição da compra: ");
            String descricao = teclado.next();

            System.out.println("Digite o valor da compra: ");
            double valor = teclado.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartaoDeCredito.lancarCompra(compra);


            if (compraRealizada){
                System.out.println("Comprado!");
                System.out.println("Digite 0 para sair ou 1 para continuar comprando!");
                sair = teclado.nextInt();
            } else {
                System.out.println("Saldo insuficiente!!!");
                sair = 0;
            }
        }


        System.out.println("#################################################");
        System.out.println("Compra(s) realizadas: \n");


        Collections.sort(cartaoDeCredito.getCompras());

        for (Compra c : cartaoDeCredito.getCompras()){
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }


        System.out.println("#################################################");


        System.out.println("\n Saldo do carão: " + cartaoDeCredito.getSaldo());



    }
}
