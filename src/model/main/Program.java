package model.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installments;
import model.services.ContractService;
import model.services.PayPalService;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");	

		System.out.println("ENTRE COM OS DADOS DO BOLETO");
		System.out.print("Numero do boleto: ");
		int numBol = sc.nextInt(); 
		System.out.print("Data (DD/MM/YYYY): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt); 
		System.out.print("Entre com o valor do contrato: ");
		double value = sc.nextDouble(); 
		Contract obj = new Contract(numBol, date, value);
		
		System.out.print("Entre com o numero de parcelas: ");
		int n = sc.nextInt(); 
		
		ContractService contractService = new ContractService( new PayPalService());
		contractService.processContract(obj, n);
		
		System.out.println("PARCELAS");
		for (Installments installment : obj.getInstallments() ) {
			System.out.println(installment);
		}
	
	}
}
