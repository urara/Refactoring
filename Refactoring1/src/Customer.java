import java.util.Enumeration;
import java.util.Vector;


public class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();
	//ラクガキ
	public Customer(String name){
		_name = name;
	}
	
	public void addRental(Rental arg){
		_rentals.addElement(arg);
	}
	public String getName(){
		return _name;
	}
	
	public String statement(){
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while(rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();
	
			//この貸し出しに関する数値の表示
			result += "\t" + each.getMovie().getTitle() + "\t" +
					String.valueOf(each.getCharge()) + "\n";
			
		}
		
		//フッタ追加
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + 
				" frequent renter points";
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each = rentals.nextElement();
			result += each.getFrequentPoints();
		}
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	public String htmlStatement(){
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		while(rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			result += each.getMovie().getTitle() + ": " +
						String.valueOf(each.getCharge()) + "<BR>\n";
		}
		//フッタ追加
			result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM></P>\n";
			result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + 
					"</EM> frequent renter points<P>";
			return result;
	}
}
