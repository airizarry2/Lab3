import java.util.Comparator;

public class mortgageComparator implements Comparator<BankRecords>{
	 
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
	// use compareTo to compare strings
	int result = o1.getMortgage().compareTo(o2.getMortgage());
	return result;
	}
}
