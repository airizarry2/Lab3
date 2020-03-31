
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Author: Anthony Irizarry
//Date: 2/27/2020

public class BankRecords {

	//array of Bankrecords objects
	static BankRecords robjs[] = new BankRecords[600];
	
	//arraylist to hold spreadsheet rows and columns
	static ArrayList<List<String>> array= new ArrayList<>();	
	
	
	//Instance Variables
	private String id;
	private int age;
	private String sex;
	private String region;
	private double income;
	private String married;
	private String children;
	private String car;
	private String save_act;
	private String current_act;
	private String mortgage;
	private String pep;
	
	//Getters and Setters
	
	//id getter and setter
	public String getid() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id= id;
	}
	
	//age getter and setter
	public int getAge() {
	return this.age;
	}
	
	public void setAge(int age) {
		this.age= age;
	}
	
	//region getter and setter
	public String getRegion() {
		return this.region;
	}
	
	public void setRegion(String region) {
		this.region= region;
	}
	
	
	//income getter and setter
	public double getIncome() {
		return this.income;
	}
	
	public void setIncome(double income) {
		this.income= income;
	}
	
	//Married getter and setter
	public String getMarried() {
		return this.married;
	}
	
	public void setMarried(String married) {
		this.married= married;
		
	}
	
	//Children getter and setter
	public String getChildren() {
		return this.children;
	}
	
	public void setChildren(String children) {
		this.children=children;
	}
	
	//Car getter and setter
	public String getCar() {
		return this.car;
	}
	
	public void setCar(String car) {
		this.car=car;
	}
	
	//Savings account getters and setters
	public String getSave_act() {
		return this.save_act;
	}
	
	public void setSave_act(String save_act) {
		this.save_act=save_act;
	}
	
	//Current Account getters and setters
	public String getCurrent_act() {
		return this.current_act;
	}
	
	public void setCurrent_act(String current_act) {
		this.current_act= current_act;
	}
	
	
	//Mortgage getters and setters
	public String getMortgage() {
		return this.mortgage;
	}
	
	public void setMortgage(String mortgage) {
		this.mortgage= mortgage;
	}
	
	
	//pep getters and setters
	public String getPep() {
		return this.pep;
	}
	
	public void setPep(String pep) {
		this.pep=pep;
	}
	
	//Sex getters and setters
	public String getSex() {
		return this.sex;
	}
	
	public void setSex(String sex) {
		this.sex=sex;
	}
	
	public void readData() {
	
		BufferedReader br; 
		
		try {
		br = new BufferedReader(new FileReader (new File("bank-Detail.csv")));
		
		String line;
		
		while ((line= br.readLine()) != null) {
			array.add(Arrays.asList(line.split(",")));
		}
		} catch (FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch (IOException e) {
			System.out.println("IO Exception");
		}
		processData();
	}
	
	public  void processData(){
		
		int idx=0;
		
		for (List<String>rowData:array) {
			robjs[idx] = new BankRecords();
			
			//Calling setters and populating them 
			robjs[idx].setId(rowData.get(0));
			robjs[idx].setAge(Integer.parseInt(rowData.get(1)));
			robjs[idx].setSex(rowData.get(2));
			robjs[idx].setRegion(rowData.get(3));
			robjs[idx].setIncome(Double.parseDouble(rowData.get(4)));
			robjs[idx].setMarried(rowData.get(5));
			robjs[idx].setChildren((rowData.get(6)));
			robjs[idx].setCar(rowData.get(7));
			robjs[idx].setSave_act(rowData.get(8));
			robjs[idx].setCurrent_act(rowData.get(9));
			robjs[idx].setMortgage(rowData.get(10));
			robjs[idx].setPep(rowData.get(11));
			
			idx++;
		}
		
		printData();
		
	}

	
	public void  printData() {
		
		System.out.println("id\t \tage\t \tsex \tregion\t \tincome\t \tmortgage\t");
		
		
		
		for (int i= 0; i<25; i++) {
			System.out.print(robjs[i].getid()+ "\t\t" + robjs[i].getAge()+ "\t\t" + robjs[i].getSex()+ "\t");  
		
			if (robjs[i].getRegion().contentEquals("RURAL") |  robjs[i].getRegion().contentEquals("TOWN")) {
				System.out.print(robjs[i].getRegion()+ "\t\t");
			}
			else {
				System.out.print(robjs[i].getRegion()+ "\t");
			}
			
		System.out.print(robjs[i].getIncome()+ "\t\t" +  robjs[i].getMortgage() + "\n") ;
			
		}
		
		
		
		
	}
	
	
}
