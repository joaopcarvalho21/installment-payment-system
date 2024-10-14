package application;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Enter contract details:");
            
            System.out.print("Number: ");
            int number = sc.nextInt();
            
            System.out.print("Date (dd/MM/yyyy): ");
            String dateInput = sc.next();
            LocalDate date;
            try {
                date = LocalDate.parse(dateInput, fmt);
            } 
            catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format. Please enter the date in the format dd/MM/yyyy.");
            }

            System.out.print("Total contract value: ");
            double totalValue = sc.nextDouble();
            
            Contract contract = new Contract(number, date, totalValue);
            
            System.out.print("Enter the number of installments: ");
            int n = sc.nextInt();

            ContractService contractService = new ContractService(new PaypalService());
            contractService.processContract(contract, n);

            System.out.println("Installments:");
            for (Installment installment : contract.getInstallments()) {
                System.out.println(installment);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data types.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}