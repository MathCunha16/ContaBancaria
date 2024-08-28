package classe;

import java.util.Scanner;

public class ContaBancariaMain {

	private static double convertStringToDouble(String stringMoneyValue) {
		return Double.parseDouble(stringMoneyValue.replace(',', '.'));
		// Metódo de conversão (,) -> (.)
	}

	public static void main(String[] args) {
		int valueForNavegation;
		String stringValueForNavegation;
		double moneyValue;
		String stringMoneyValue;
		int menuLoop = 1;
		String stringMenuLoop;
		boolean numberOnStringVerificator;
		boolean stringOnNumberVerificator;

		ContaBancariaObjeto clientOne = new ContaBancariaObjeto();
		Scanner entrada = new Scanner(System.in);

		System.out.println("==================================================================");
		System.out.println("Bem vindo ao NeyBank, Para inciar seu cadastro: ");
		System.out.println("==================================================================");
		System.out.println("Insira aqui o seu nome completo: ");
		clientOne.setAccountOwner(entrada.nextLine());
		numberOnStringVerificator = clientOne.getAccountOwner().matches("^[^0-9]*$");

		if (clientOne.getAccountOwner().length() < 10 || !numberOnStringVerificator) {
			do {

				System.err.println("ERRO!");
				System.out.println("Insira um nome completo e valido, por favor: ");
				clientOne.setAccountOwner(entrada.nextLine());
				numberOnStringVerificator = clientOne.getAccountOwner().matches("^[^0-9]*$");

			} while (clientOne.getAccountOwner().length() < 10 || numberOnStringVerificator == false);
		}

		System.out.println("==================================================================");
		System.out.println("Insira aqui o número de sua conta: ");
		System.out.println("Deve conter 8 números! Ex: 10.20.30.50");
		ContaBancariaObjeto.setAccountNumber(entrada.nextLine().replaceAll("[,\\-_.=/]", "."));
		stringOnNumberVerificator = ContaBancariaObjeto.getAccountNumber().matches("^[0-9.]*$");

		if (!stringOnNumberVerificator || ContaBancariaObjeto.getAccountNumber().length() != 11) {
			do {

				System.err.println("ERRO!");
				System.out.println("Digite um número valido, sem caracteres e com 8 números: ");
				ContaBancariaObjeto.setAccountNumber(entrada.nextLine().replaceAll("[,\\-_.=/]", "."));
				stringOnNumberVerificator = ContaBancariaObjeto.getAccountNumber().matches("^[0-9.]*$");

			} while (!stringOnNumberVerificator || ContaBancariaObjeto.getAccountNumber().length() != 11);
		}

		System.out.println("==================================================================");

		System.out.printf("Você deseja realizar um depósito inicial?\nSim --> 1\nNão --> Digite outro número\n ");
		stringValueForNavegation = entrada.nextLine();
		stringOnNumberVerificator = stringValueForNavegation.matches("^[0-9.]*$");
		if (!stringOnNumberVerificator)
			do {
				System.err.println("ERRO!");
				System.out.println("Digite um valor valido: ");
				stringValueForNavegation = entrada.nextLine();
				stringOnNumberVerificator = stringValueForNavegation.matches("^[0-9]*$");

			} while (!stringOnNumberVerificator);

		valueForNavegation = Integer.parseInt(stringValueForNavegation);

		if (valueForNavegation == 1) {

			System.out.println("Digite o Valor que deseja depositar: ");
			stringMoneyValue = entrada.nextLine();
			stringOnNumberVerificator = stringMoneyValue.matches("^[0-9.,]*$");
			if (!stringOnNumberVerificator) {
				do {

					System.err.println("ERRO!");
					System.out.println("Digite um valor valido: ");
					stringMoneyValue = entrada.nextLine();
					stringOnNumberVerificator = stringMoneyValue.matches("^[0-9.,]*$");

				} while (!stringOnNumberVerificator);
			}

			moneyValue = convertStringToDouble(stringMoneyValue);
			clientOne.deposito(moneyValue);

		}

		do {
			valueForNavegation = -1; // Reiniciando o valor de escolha
			menuLoop = 1; // Reiniciando o valor do looping
			moneyValue = 0; // Reiniciando o valor de dinheiro
			System.out.println("==================================================================");
			System.out.println("Olá " + clientOne.getAccountOwner());
			System.out.printf("Seu saldo atual é de R$%.2f\n", clientOne.getSald());
			System.out.println("O número da sua conta é: " + ContaBancariaObjeto.getAccountNumber());
			System.out.printf("O que deseja fazer?\n1-->Depositar\n2-->Sacar\n3-->Alterar Nome\n4-->Sair\n");
			valueForNavegation = entrada.nextInt();
			entrada.nextLine(); // Limpa o buffer após nextInt()
			System.out.println("==================================================================");

			if (valueForNavegation == 1) {

				System.out.println("Digite o Valor que deseja depositar: ");
				stringMoneyValue = entrada.nextLine();
				stringOnNumberVerificator = stringMoneyValue.matches("^[0-9.,]*$");
				if (!stringOnNumberVerificator) {
					do {

						System.err.println("ERRO!");
						System.out.println("Digite um valor valido: ");
						stringMoneyValue = entrada.nextLine();
						stringOnNumberVerificator = stringMoneyValue.matches("^[0-9.,]*$");

					} while (!stringOnNumberVerificator);
				}
				moneyValue = convertStringToDouble(stringMoneyValue);
				clientOne.deposito(moneyValue);
				System.out.printf("%s seu saldo atual é de: R$%.2f\n", clientOne.getAccountOwner(),
						clientOne.getSald());
				System.out.printf("Digite 1 -->Para voltar ao menu\nDigite 0 -->Para encerrar\n");
				stringMenuLoop = entrada.nextLine();
				stringOnNumberVerificator = stringMenuLoop.matches("^[0-9.]*$");
				if (!stringOnNumberVerificator)
					do {
						System.err.println("ERRO!");
						System.out.println("Digite um valor valido: ");
						stringMenuLoop = entrada.nextLine();
						stringOnNumberVerificator = stringMenuLoop.matches("^[0-9]*$");

					} while (!stringOnNumberVerificator);

				menuLoop = Integer.parseInt(stringMenuLoop);

			} else if (valueForNavegation == 2) {

				System.out.println("Inforamos que os saques tem um valor de R$5 ");
				System.out.println("Digite o Valor que deseja Sacar: ");
				stringMoneyValue = entrada.nextLine();
				stringOnNumberVerificator = stringMoneyValue.matches("^[0-9.,]*$");
				if (!stringOnNumberVerificator) {
					do {

						System.err.println("ERRO!");
						System.out.println("Digite um valor valido: ");
						stringMoneyValue = entrada.nextLine();
						stringOnNumberVerificator = stringMoneyValue.matches("^[0-9.,]*$");

					} while (!stringOnNumberVerificator);
				}
				moneyValue = convertStringToDouble(stringMoneyValue);
				clientOne.saque(moneyValue);
				System.out.printf("%s seu saldo atual é de: R$%.2f\n", clientOne.getAccountOwner(),
						clientOne.getSald());
				System.out.printf("Digite 1 -->Para voltar ao menu\nDigite 0 -->Para encerrar\n");
				stringMenuLoop = entrada.nextLine();
				stringOnNumberVerificator = stringMenuLoop.matches("^[0-9.]*$");
				if (!stringOnNumberVerificator)
					do {
						System.err.println("ERRO!");
						System.out.println("Digite um valor valido: ");
						stringMenuLoop = entrada.nextLine();
						stringOnNumberVerificator = stringMenuLoop.matches("^[0-9]*$");

					} while (!stringOnNumberVerificator);

				menuLoop = Integer.parseInt(stringMenuLoop);

			} else if (valueForNavegation == 3) {

				System.out.println("Qual o novo nome que você deseja inserir? ");
				clientOne.setAccountOwner(entrada.nextLine());
				numberOnStringVerificator = clientOne.getAccountOwner().matches("^[^0-9]*$");

				if (clientOne.getAccountOwner().length() < 10 || !numberOnStringVerificator) {
					do {

						System.err.println("Não foi possivel alterar o nome!");
						System.out.println("Insira um nome valido, por favor: ");
						clientOne.setAccountOwner(entrada.nextLine());
						numberOnStringVerificator = clientOne.getAccountOwner().matches("^[^0-9]*$");

					} while (clientOne.getAccountOwner().length() < 10 || numberOnStringVerificator == false);
				}
				System.out.println("Nome alterado com sucesso --> " + clientOne.getAccountOwner());
				System.out.printf("Digite 1 -->Para voltar ao menu\nDigite 0 -->Para encerrar\n");
				stringMenuLoop = entrada.nextLine();
				stringOnNumberVerificator = stringMenuLoop.matches("^[0-9.]*$");
				if (!stringOnNumberVerificator)
					do {
						System.err.println("ERRO!");
						System.out.println("Digite um valor valido: ");
						stringMenuLoop = entrada.nextLine();
						stringOnNumberVerificator = stringMenuLoop.matches("^[0-9]*$");

					} while (!stringOnNumberVerificator);

				menuLoop = Integer.parseInt(stringMenuLoop);

			} else if (menuLoop == 0 || valueForNavegation == 4) {

				System.exit(0);
			}

			if (valueForNavegation < 1 || valueForNavegation > 4) {

				System.err.println("Valor invalído, tente novamente! ");

			}

			if (menuLoop < 0 || menuLoop > 1) {

				System.err.println("Valor Invalído, retornando ao menu...");
				menuLoop = 1;
			}

		} while (menuLoop == 1);

		entrada.close();
	}
}
