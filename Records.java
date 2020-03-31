import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.lang.Math; 

public class Records extends BankRecords{
	
	static FileWriter fw = null;
	

public Records() {
	try {
		fw = new FileWriter("C:\\Users\\junie\\eclipse-workspace\\Lab2_AI\\bankrecords.txt");

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
		 
		double femAVIncome = femInc/femCt;
		double maleAVIncome= maleInc/maleCt;
		
		
		
		System.out.print("Avg inc. for Females: femAVIncome= $");
		System.out.print(Math.round(femAVIncome));
		System.out.print("\nAvg inc. for Males: maleAVIncome= $");
		System.out.print(Math.round(maleAVIncome));
		
		try {
			fw.write("Avg inc. for Females: $" + Math.round(femAVIncome) );
			fw.write("\nAvg inc. for Males: $" + Math.round(maleAVIncome));
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
		fw.write("\nNumber of Females that have a Mortgage and Savings Account: " + femMS);
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
		if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES")&& robjs[i].getRegion().equals("SUBURBAN")&& robjs[i].getChildren().equals("1") ) {
			++male;
		}
		else if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getRegion().equals("TOWN")&& robjs[i].getChildren().equals("1")){
		++male;
	}
	    else if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getRegion().equals("RURAL")&& robjs[i].getChildren().equals("1")){
			++male;
		}
	    else if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getRegion().equals("INNER_CITY") && robjs[i].getChildren().equals("1")){
			++male;
		}
	
	System.out.println("\nNumber of Males that have both a car and 1 Child per location:" + male);
	
	try {
		fw.write("\nNumber of Males that have both a car and 1 Child per location: " + male);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

	
	
	}


	



		
	

