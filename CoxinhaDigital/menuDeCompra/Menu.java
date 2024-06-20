package menuDeCompra;

import coxinha.model.Assado;
import coxinha.model.Coxinha;
import coxinha.model.Frito;
import coxinha.util.*;
import coxinha.controller.*;
import coxinha.repository.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		CoxinhaController Coxinha = new CoxinhaController();
		
		int opcao,quant, numero, codigo = 0, tipo;
		;
		String produto;
		

		while (true) {
			System.out.println(Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("              BEM VINDO AO COXINHA DIGITAL           ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar todos produtos                ");
			System.out.println("            3 - Buscar produtos por numero           ");
			System.out.println("            4 - Atualizar produtos                   ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            9 - Sair                                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com o numero desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\n DIGITE NUMEEROS =)");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("Coxinha digital, matando sua fome até virtual!!! ;)");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "\n Cadastrar Produto");

				System.out.println("Digite a quantidade que deseja adicionar: ");
				quant = leia.nextInt();
				System.out.println("Digite o Nome do Produto:  ");
				leia.skip("\\R?");
				produto = leia.nextLine();

				do {
					System.out.println("Digite o tipo de produto 1-Frito  2- Assado: ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);


				switch (tipo) {
				case 1 -> {
	
					Coxinha.cadastrar(new Frito(Coxinha.gerarNumero(), tipo, quant, produto));
				}
				case 2 -> {
					Coxinha.cadastrar(new Assado(Coxinha.gerarNumero(), tipo, quant, produto  ));

				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "\n Listar todos produtos");
				Coxinha.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "\n Buscar produtos por numero");
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();

				Coxinha.procurarPorNumero(codigo);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "\n Atualizar produtos");

				System.out.println("Digite o codigo do produto: ");
				codigo = leia.nextInt();

				var buscaprod = Coxinha.buscarNaColletion(codigo);

				if (buscaprod != null) {
					tipo = buscaprod.getTipo();

					System.out.println("Digite o Codigo do produto: ");
					codigo = leia.nextInt();
					System.out.println("DIgite o nome do produto:  ");
					leia.skip("\\R?");
					produto = leia.nextLine();

					System.out.println("digite a Quantidade que deseja mudar:  ");
					quant = leia.nextInt();
					switch (tipo) {
					case 1 -> {

						Coxinha.atualizar(new Frito(Coxinha.gerarNumero(), tipo, quant, produto));
					}
					case 2 -> {
						System.out.println(" ");
						Coxinha.atualizar(new Assado(Coxinha.gerarNumero(), tipo, quant, produto ));
					}
					default -> {
						System.out.println("Tipo de conta invalido!");
					}
					}
				} else {
					System.out.println("Conta não  foi encontrada!");
					keyPress();
					break;
				}
			case 5:
				System.out.println(Cores.TEXT_WHITE + "\n Apagar Produto  ");
				System.out.println("Digite o codigo do produto que deseja apagar: ");
				codigo = leia.nextInt();
				Coxinha.deletar(codigo);
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_WHITE + "\nOperação Inválida" + Cores.TEXT_RESET);

				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Édipo Reis Torres ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("github.com/EdiporTorres");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\n Pressione Enter para Continuar..");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla  diferente de enter!");
		}
	}
}
