package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.model.XicaraCeramica;
import projeto_final_bloco_01.model.XicaraPlastico;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		
		ProdutoController produtos = new ProdutoController();
		
		int opcao, id, tipo;
		String nome, cor, durabilidade;
		float preco;

		//Testee
		
		//XicaraPlastico xp1 = new XicaraPlastico(produtos.gerarId(), "Xícara de bolinhas estilo 1950", 1, 15.99f, "Vermelho e branco");
		//produtos.cadastrar(xp1);
		//xp1.visualizar();
		
		//XicaraCeramica xc1 = new XicaraCeramica(produtos.gerarId(), "Xícara oriental", 2, 18.99f, "Frágil");
		//produtos.cadastrar(xc1);
		//xc1.visualizar();
		
		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                  CASA DAS XÍCARAS!                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Xícara                         ");
			System.out.println("            2 - Listar todas as Xícaras              ");
			System.out.println("            3 - Buscar Xícara por ID                 ");
			System.out.println("            4 - Atualizar Tipo de Xícara             ");
			System.out.println("            5 - Apagar Xícara                        ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 6) {
				System.out.println("\nCasa das Xícaras - O melhor lugar para colecionar xícaras e sorrisos!");
				sobre();
                 leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Criar Xícara\n\n");
					
					System.out.println("Digite o nome da Xícara: ");
					leia.skip("\\R");
					nome = leia.nextLine();

					System.out.println("Digite o tipo da Xícara (1 - PLASTICO | 2 - CERÂMICA:)");
					tipo = leia.nextInt();

					System.out.println("Digite o preço da Xícara: ");
					preco = leia.nextFloat();

					switch (opcao) {
					case 1 -> {
						
						System.out.println("Digite a cor da Xícara: ");
						leia.skip("\\R");
						cor = leia.nextLine();
						produtos.cadastrar(new XicaraPlastico(produtos.gerarId(), nome, tipo, preco, cor));
					}
					case 2 -> {
						System.out.println("Digite a durabilidade da Xícara: ");
						leia.skip("\\R");
						durabilidade = leia.nextLine();
						produtos.cadastrar(new XicaraCeramica(produtos.gerarId(), nome, tipo, preco, durabilidade));
					}
					}
					
					keyPress();
					break;
				case 2:
					System.out.println("Listar todas as Xícaras\n\n");
					produtos.listarTodos();
					
					keyPress();
					break;
				case 3:
					System.out.println("Buscar tipo de Xícara - por Número/ID\n\n");
					System.out.println("Digite o ID da Xícara: ");
					id = leia.nextInt();

					produtos.procurarPorId(id);
					
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar tipo de Xícara\n\n");
					System.out.println("Digite o ID da Xícara: ");
					id = leia.nextInt();

					Optional<Produto> produto = produtos.buscarNaCollection(id);
					
		
					if(produto.isPresent()) {
						
						System.out.println("Digite o nome da Xícara: ");
						leia.skip("\\R");
						nome = leia.nextLine();
		
						tipo = produto.get().getTipo();
		
						System.out.println("Digite o preço da Xícara: ");
						preco = leia.nextFloat();
		
						switch (opcao) {
							case 1 -> {
								System.out.println("Digite a cor da Xícara: ");
								leia.skip("\\R");
								cor = leia.nextLine();
								produtos.atualizar(new XicaraPlastico(id, nome, tipo, preco, cor));
							}
							case 2 -> {
								System.out.println("Digite a durabilidade da Xícara: ");
								leia.skip("\\R");
								durabilidade = leia.nextLine();
								produtos.atualizar(new XicaraCeramica(id, nome, tipo, preco, durabilidade));
							}
						}
					} else 
						System.out.printf("\n A Xícara ID %d não existe!", id);

					
					keyPress();
					break;
				case 5:
					System.out.println("Apagar Xícara\n\n");
					System.out.println("Digite o ID da Xícara: ");
					id = leia.nextInt();

					produtos.deletar(id);
					
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