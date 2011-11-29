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
		//double totalAmount = 0;
		//int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while(rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();
	
			//レンタルポイントを加算
			//frequentRenterPoints += each.getFrequentPoints();
			
			//この貸し出しに関する数値の表示
			result += "\t" + each.getMovie().getTitle() + "\t" +
					String.valueOf(each.getCharge()) + "\n";
			//totalAmount += each.getCharge();
			
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
	
}
