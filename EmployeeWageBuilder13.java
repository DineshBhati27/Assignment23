import java.util.*;
interface IComputeWage {
	public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maximumHoursPerMonth);
	public void computeEmpWage();
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
	public void setTotalEmpWage(int totalWage){
		this.totalWage=totalWage;
	}
	public String toString() {
		return "Total Employee Wage for "+company+" is "+totalWage;
	}
}

public class EmployeeWageBuilder13 implements IComputeWage{
	public static final int isPartTime=0;
	public static final int isFullTime=1;
	private ArrayList<CompanyEmpWage> empList;
	private LinkedList<Integer>dailyWage;
	public EmployeeWageBuilder13() {
		empList=new ArrayList<>();
		dailyWage=new LinkedList<>();
	}
	
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		CompanyEmpWage empWage=new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		empList.add(empWage);
	}


	public void computeEmpWage() {
		for(int i=0;i<empList.size();i++) {
			empList.get(i).setTotalEmpWage(this.computeEmpWage(empList.get(i)));
			System.out.println(empList.get(i));
		}	
		
	}
	HashMap<String,LinkedList> companyDailyWage=new HashMap<>();
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
               dailyWage.add(empHours*companyEmpWage.empRatePerHour);
               
               }
		 companyDailyWage.put(companyEmpWage.company, dailyWage);
		 System.out.println("Daily Wage for the "+companyEmpWage.company+" is :"+dailyWage);
		 dailyWage.clear();
		  return (totalEmpHours*companyEmpWage.empRatePerHour);
		 
	}
	
	public static void main(String args[]) {
		EmployeeWageBuilder13 employeeWageBuilder=new EmployeeWageBuilder13();
		employeeWageBuilder.addCompanyEmpWage("Dmart", 15, 21, 80);
		employeeWageBuilder.addCompanyEmpWage("Reliance", 15, 18, 100);
		employeeWageBuilder.computeEmpWage();
	}
	
}