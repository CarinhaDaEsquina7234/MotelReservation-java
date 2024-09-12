package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		//Bad Solution
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin))
		{
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		
		else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation.toString());
			System.out.println();
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now))
			{
				System.out.println("Errorin reservation: Reservation dates for update must be future dates");
			}
			
			else if(checkout.after(checkin))
			{
				 System.out.println(" Errorin reservation: Check-out date must be after check-in date");
			}
			
			else {
			reservation.UpdateDates(checkin, checkout);
			
			System.out.println("Reservation: " + reservation.toString());
			}

		}
		
		sc.close();
		
	}

}
