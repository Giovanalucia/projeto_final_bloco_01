package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                  CASA DAS XÍCARAS!                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Xícara                         ");
			System.out.println("            2 - Listar todas as Xícaras              ");
			System.out.println("            3 - Buscar Xícara por Numero             ");
			System.out.println("            4 - Atualizar Tipo de Xícara             ");
			System.out.println("            5 - Apagar Xícara                        ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 6) {
				System.out.println("\nCasa das Xícaras - Colecionamos xícaras e sorrisos!");
				sobre();
                 leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Criar Xícara\n\n");
					
					keyPress();
					break;
				case 2:
					System.out.println("Listar todas as Xícaras\n\n");
					
					keyPress();
					break;
				case 3:
					System.out.println("Buscar tipo de Xícara - por número\n\n");
					
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar tipo de Xícara\n\n");
					
					keyPress();
					break;
				case 5:
					System.out.println("Apagar Xícara\n\n");
					
					keyPress();
					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					
					keyPress();
					break;
			}
		}
	}
    
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Giovana");
		System.out.println("Generation Brasil - giovanalucia835@gmail.com");
		System.out.println("GitHub: https://github.com/Giovanalucia");
		System.out.println("*********************************************************");
	}
	
	public static void keyPress() {
	   	 
		try {
			System.out.println("\n\nPressione Enter para Continuar...");
			
			//Lê apenas a tecla Enter e ignora outras teclas
			int input;
			while((input = System.in.read()) != '\n') {
				//Ignora qualquer outra tecla diferente do Enter
				if (input == -1) {
					throw new IOException("Entrada encerrada inesperada");
					
				}
			}
 
		} catch (IOException e) {
	        System.err.println("Erro de entrada/saída: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
	    }
	}

}