package Model;

import java.time.LocalTime;
import java.util.Vector;

public class Play {
	private static final char[] alphabet = {'A','B','C','D','E'};
	
	Film film;
	private final CinemaScreen screen = null;
	AvailableSeats seats;
	LocalTime startTime;
	double price;
	
	public Play(Film film, CinemaScreen screen, LocalTime startTime) {
		this.film = film;
		this.screen = screen;
		seats = new AvailableSeats(screen);
		this.startTime = startTime;
		this.price = 16.0;
	}
	
	public Play() {
	}
	
	private String takeASeat(int row, int col) {
		if( seats.seats.get(row-1).get(col-1) == 1 ){
			seats.seats.get(row-1).setElementAt(0,col-1);
			return alphabet[row-1]+""+col;
		}
		else return ""+-1;
	}
	 
	private void returnASeat(String seat) {
		int row = new Play().AtoI(seat.charAt(0));
		int col = Integer.parseInt(String.valueOf(seat.charAt(1)));
		if( seats.seats.get(row-1).get(col-1) == 0 ){
			seats.seats.get(row-1).setElementAt(1,col-1);
		}
	}
	 
	private char ItoA(int row) {
		return alphabet[row-1];
	}
	
	private int AtoI(char mark) {
		int i;
		for( i=0; i<=4; i++){
			if( alphabet[i] == mark ){
				return i+1;
			}
		}
		return -1;
	}
}
