import java.util.Random;
class Wage{
        final int isPartTime=0;
        final int isFullTime=1;
        private int empRatePerHour;
        private int totalDays;
        private int totalHours;
        private String company;
        private int totalSalary;
Wage(String company,int empRatePerHour,int totalDays,int totalHours){
        this.company=company;
        this.empRatePerHour=empRatePerHour;
        this.totalDays=totalDays;
        this.totalHours=totalHours;
        }
public void calculate(){
        int hours=0;
        int days=0;
        int salary=0;
        int empHours;
        Random ran=new Random();
        while(hours<=totalHours && days<totalDays){
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
                hours+=empHours;
                days+=1;
                salary=empRatePerHour*empHours;
                totalSalary=totalSalary+salary;
  }
}
public String toString(){
        return "Total Employee wage for " + company +" is " +totalSalary;
}
}
public class EMPUC9{
public static void main(String args[]){
        Wage dmart=new Wage("Dmart",20,20,80);
        Wage reliance=new Wage("Reliance",10,20,100);
        dmart.calculate();    //If you print any object, java compiler internally invokes the toString() method on the object.                                 So overriding the toString() method, returns the desired output
	    
        reliance.calculate();
        System.out.println(dmart); // like dmart.tostring()
        System.out.println(reliance); //like reliance.tostring()
}
}