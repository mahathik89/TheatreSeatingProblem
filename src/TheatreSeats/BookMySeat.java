package TheatreSeats;

import java.io.IOException;
import java.util.List;

public class BookMySeat {

	public static void main(String[] args) {
		
		TheatreLayout theatreLayout= new TheatreLayout();
		SeatRequest seatRequest = new SeatRequest();
		try {
			theatreLayout.setTheatreLayout();
			seatRequest.setSeatRequest();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> finalList= theatreLayout.assignSeats(seatRequest);
		finalList.forEach(element -> System.out.println(element));
		    }
		  }

