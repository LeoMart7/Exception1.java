package application;

import java.util.Scanner;
import model.entities.Reservation;

import model.exceptions.DomainException;

import java.text.ParseException;
import java.util.InputMismatchException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgramEX {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room: ");
			int room = input.nextInt();
	
			System.out.print("Check-in (dd/mm/aaaa): ");
			Date checkin = sdf.parse(input.next());
	
			System.out.print("Check-out (dd/mm/aaaa): ");
			Date checkout = sdf.parse(input.next());
	
			
			Reservation reserv = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: " + reserv);
			
			System.out.println("");
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in (dd/mm/aaaa): ");
			checkin = sdf.parse(input.next());
	
			System.out.print("Check-out (dd/mm/aaaa): ");
			checkout = sdf.parse(input.next());
	
			reserv.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reserv);
			
		} catch(ParseException e) {
			System.out.println("Invalid date format");
			
		} catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
			
		} catch(InputMismatchException e) {
			System.out.println("This type does not accept characters");
			
		} catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		

		input.close();
	}
}
