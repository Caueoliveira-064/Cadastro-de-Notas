package atividades.lanchonete;

import java.util.Scanner;

public class Pedidoslanchonete {

    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);
        
        String[] nome = new String[5];    
        
        for (int i = 0; i < 1; i++) {
			System.out.println(" Digite o seu nome ");
			nome[i] = input.nextLine();		
        }
        String[] produtos = {"Hambúrguer", "Batata Frita", "Refrigerante", "Milkshake"};
        double[] precos = {15.0, 8.0, 7.5, 10.0};
        int[] quantidades = new int[produtos.length];

        System.out.println("=== CARDÁPIO DA LANCHONETE ===");
        for (int i = 0; i < produtos.length; i++) {
            System.out.printf("%d - %s: R$ %.2f\n", i + 1, produtos[i], precos[i]);
        }

        System.out.println("\nInforme a quantidade desejada de cada item:");
        for (int i = 0; i < produtos.length; i++) {
            System.out.print(produtos[i] + ": ");
            quantidades[i] = input.nextInt();
        }

        double total = 0;
        System.out.println("\n=== PEDIDO ===");
        for (int i = 0; i < produtos.length; i++) {
            if (quantidades[i] > 0) {
                double subtotal = quantidades[i] * precos[i];
                total += subtotal;
                System.out.printf("%s x%d - R$ %.2f\n", produtos[i], quantidades[i], subtotal);
            }
        }

        System.out.printf("\nTOTAL TOTAL: R$ %.2f\n", total);
        input.close();
    }
}