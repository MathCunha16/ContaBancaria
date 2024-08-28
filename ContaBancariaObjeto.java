package classe;

public class ContaBancariaObjeto {

	private static String accountNumber;
	private String AccountOwner;
	private double sald;

	public static String getAccountNumber() {
		return accountNumber;
	}

	public static void setAccountNumber(String accountNumber) {
		ContaBancariaObjeto.accountNumber = accountNumber;
	}

	public String getAccountOwner() {
		return AccountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		AccountOwner = accountOwner;
	}

	public double getSald() {
		return sald;
	}

	public void setSald(double sald) {
		this.sald = sald;
	}

	public ContaBancariaObjeto() {
		this.sald = 0.0;
		this.AccountOwner = "";
	}

	public void deposito(double valor) {
		if(valor >= 0.1) {
		this.sald = this.sald + valor;
		} else {
			
			System.err.println("Não é possível inserir valores negativos ou nulos! ");
		}
	}

	public void saque(double valor) {
		if (valor + 5 <= sald) {
			this.sald = this.sald - valor - 5;
		} else { 
			
			System.err.println("Saldo insuficiente!");
		}

	}

}
