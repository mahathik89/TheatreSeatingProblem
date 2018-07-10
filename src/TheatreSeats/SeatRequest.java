package TheatreSeats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SeatRequest {
 
	List<String> seatRequest = new ArrayList<String>();
	
	
	public List<String> getseatRequest(){
		return seatRequest;
	}
	
	public void setSeatRequest() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter requset");
		 while(true) {
			  String line= br.readLine();
	            if (line == null || line.isEmpty()) {
	                break;
	            }
	            seatRequest.add(line);
	        }
	}
}
