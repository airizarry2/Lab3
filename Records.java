import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Records extends BankRecords{
	
	static FileWriter fw = null;
	

public Records() {
	try {
		fw = new FileWriter("bankrecords.txt");

	} catch (IOException e) {
		e.printStackTrace();
	}

}
public static void main(String[] args) {

	Records br = new Records();
	br.readData();

	// call functions to perform analytics
	AvgComp();     // analyze average income per loc
	femsComp();  // female count w. mort/savings accounts 
	malesComp(); // male counts per loc. w. car & 1 child 

	// *** close out file object ***//

	try {
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
private static void AvgComp() {

Arrays.sort(robjs, new SexComparator());

		// set up needed variables to gather counts & income by sex 
		// to determine average income by sex
        
	   	 int maleCt = 0, femCt = 0;
         double maleInc =0, femInc = 0;
      
		for (int i = 0; i < robjs.length; i++)
			if (robjs[i].getSex().equals("FEMALE")) {
				++femCt;
				femInc += robjs[i].getIncome();
			}  
			else {
				++maleCt;
				maleInc += robjs[i].getIncome();
			}
			 
		// display resulting averages to console and to file
		 
		System.out.println("Avg inc. for Females: $" + (femInc/femCt));
		System.out.println("Avg inc. for Females: $" + (maleInc/maleCt));

		try {
			fw.write("Avg inc. for Females: $" + (femInc/femCt) );
			fw.write("Avg inc. for Males: $" + (maleInc/maleCt));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

private static void femsComp() {
	Arrays.sort(robjs, new mortgageComparator());
	Arrays.sort(robjs, new savingComparator());
	Arrays.sort(robjs, new SexComparator());
	
	int femMS = 0;
	for (int i = 0; i < robjs.length; i++) {
		if (robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES")&& robjs[i].getSave_act().equals("YES")  ) {
			++femMS;
		}
	}
	
	System.out.println("\nNumber of Females that have a Mortgage and Savings Account: " + femMS);
	try {
		fw.write("Number of Females that have a Mortgage and Savings Account: " + femMS);
	} catch (IOException e) {
		e.printStackTrace();
	}
}

private static void malesComp() {

	Arrays.sort(robjs, new SexComparator());
	Arrays.sort(robjs, new LocationComparator());
	Arrays.sort(robjs, new carComparator());
	
	int male=0;
	
	for (int i = 0; i < robjs.length; i++)
		if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES")&& robjs[i].getRegion().equals("SUBURBAN") ) {
			++male;
		}
		else if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getRegion().equals("TOWN")){
		++male;
	}
	    else if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getRegion().equals("RURAL")){
			++male;
		}
	    else if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getRegion().equals("INNER_CITY")){
			++male;
		}
	
	System.out.println("\nNumber of Males that have both a car and 1 Child per location:" + male);
	
	try {
		fw.write("Number of Males that have both a car and 1 Child per location: " + male);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

	
	
	}


	



		
	

