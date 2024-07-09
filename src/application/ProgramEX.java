package application;

import java.util.Scanner;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgramEX {
	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room: ");
		int room = input.nextInt();

		System.out.print("Check-in (dd/mm/aaaa): ");
		Date checkin = sdf.parse(input.next());

		System.out.print("Check-out (dd/mm/aaaa): ");
		Date checkout = sdf.parse(input.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
		
		} else {
			Reservation reserv = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: " + reserv);
			
			System.out.println("");
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in (dd/mm/aaaa): ");
			checkin = sdf.parse(input.next());

			System.out.print("Check-out (dd/mm/aaaa): ");
			checkout = sdf.parse(input.next());

			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
				
			} else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: check-out date must be after check-in date");
				
			} else {
				reserv.updateDates(checkin, checkout);
				System.out.println("Reservation: " + reserv);
			}
		}

		input.close();
	}
}
