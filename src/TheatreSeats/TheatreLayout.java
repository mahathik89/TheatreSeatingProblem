package TheatreSeats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TheatreLayout {

	private List<int[]> theatreLayout = new ArrayList<int[]>();
	
	public void theatreLayout() {
		 try {
			setTheatreLayout();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> assignSeats(SeatRequest seatRequest ) {
		List<String> finalList= new ArrayList<String>();
		for (String entry : seatRequest.getseatRequest()) {
			int flag=0;
			int remainingSeats=0;
			String[] seat= entry.split(" ");
			String name=seat[0];
			int seatNumber=Integer.parseInt(seat[1]);
			for (int r=1; r<=theatreLayout.size();r++) {
				    if (flag==1) {
					break;
				    }
				 int[] row= theatreLayout.get(r-1);
				for (int section = 1; section<=row.length; section++) {
					    if (seatNumber <=row[section-1]) {
						finalList.add(name +" "+"row "+r+ " Section"+" "+  section);
						row[section-1]= row[section-1]- seatNumber;
						flag=1;
						remainingSeats+=row[section-1];
						break;
					}
					remainingSeats+=row[section-1];
				
					
					
				}
			}
			if (flag==0) {
				if(seatNumber < remainingSeats) {
					finalList.add(name+" "+ " Call to split party");
				}else {
					finalList.add(name+" "+ " Sorry, we can't handle your party");
				}
				
				
			}
		}
		return finalList;
	}
	
	public void setTheatreLayout() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter layout");
		 while(true) {
			  String line= br.readLine();
	            if (line == null || line.isEmpty()) {
	                break;
	            }
	            int[] input= Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
	            theatreLayout.add(input);
	        }
	}
}
