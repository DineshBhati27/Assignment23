import java.util.Random;
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

public class EmployeeWageBuilder10{
	public static final int isPartTime=0;
	public static final int isFullTime=1;
	private int numOfCompany;
	private CompanyEmpWage empWageArray[];
	public EmployeeWageBuilder10() {
		empWageArray=new CompanyEmpWage[5];
	}
	private void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maximumHoursPerMonth) {
		empWageArray[numOfCompany]=new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		numOfCompany++;
	}
	private void computeEmpWage() {
		for(int i=0;i<numOfCompany;i++) {
			empWageArray[i].setTotalEmpWage(this.computeEmpWage(empWageArray[i]));
			System.out.println(empWageArray[i]);
		}
	}
	private int computeEmpWage(CompanyEmpWage companyEmpWage) {
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
		 return totalEmpHours * companyEmpWage.empRatePerHour;

	}
	public static void main(String args[]) {
		EmployeeWageBuilder10 employeeWageBuilder=new EmployeeWageBuilder10();
		employeeWageBuilder.addCompanyEmpWage("Dmart", 15, 21, 80);
		employeeWageBuilder.addCompanyEmpWage("Reliance", 15, 22, 100);
		employeeWageBuilder.computeEmpWage();
		
	}
}