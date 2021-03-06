import java.util.*;
interface IComputeWage {
	public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maximumHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}

class CompanyEmpWage {
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maximumHoursPerMonth;
	public int totalWage;
	public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maximumHoursPerMonth = maximumHoursPerMonth;
	}
	public void setTotalEMpWage(int totalWage){
		this.totalWage=totalWage;
	}
	public String toString() {
		return "Total Employee Wage for "+company+" is "+totalWage;
	}
}

public class EmployeeWageBuilder14 implements IComputeWage{
	public static final int isPartTime=0;
	public static final int isFullTime=1;
	private ArrayList<CompanyEmpWage> empList;
	private Map<String,CompanyEmpWage> empWageMap;
	public EmployeeWageBuilder14() {
		empList=new ArrayList<>();
		empWageMap=new HashMap<>();
	}
	
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		CompanyEmpWage empWage=new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		empList.add(empWage);
		empWageMap.put(company,empWage);
	}

	public void computeEmpWage() {
		for(int i=0;i<empList.size();i++) {
			empList.get(i).setTotalEMpWage(this.computeEmpWage(empList.get(i)));
			System.out.println(empList.get(i));
		}	
		
	}
    
	public int getTotalWage(String company) {
		return empWageMap.get(company).totalWage;
	}
	
	private  int computeEmpWage(CompanyEmpWage companyEmpWage) {
		int empHours=0, totalEmpHours=0, totalWorkingDays=0;
         Random ran=new Random();        
		 while(totalEmpHours<=companyEmpWage.maximumHoursPerMonth && totalWorkingDays<companyEmpWage.numOfWorkingDays){
             int empCheck=ran.nextInt(2);
               switch(empCheck){
               case isPartTime:
                       empHours=4;
                       break;
               case isFullTime:
                       empHours=8;
                       break;
               default :
                       empHours=0;
               }
               totalEmpHours+=empHours;
               totalWorkingDays+=1;
               }
		  return (totalEmpHours*companyEmpWage.empRatePerHour);

	}
	public static void main(String args[]) {
		EmployeeWageBuilder14 employeeWageBuilder=new EmployeeWageBuilder14();
		employeeWageBuilder.addCompanyEmpWage("Dmart", 15, 21, 80);
		employeeWageBuilder.addCompanyEmpWage("Reliance", 15, 18, 100);
		employeeWageBuilder.computeEmpWage();
		System.out.println("Total wage for Reliance company: "+employeeWageBuilder.getTotalWage("Reliance"));
	}
	
}