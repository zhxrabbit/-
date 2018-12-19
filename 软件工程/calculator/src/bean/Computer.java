package bean;

public class Computer {
	private double num1;
	private double num2;
	private String oper;
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	
	public double calculate(double num1,double num2,String oper){
		double result=0;
		if (oper.equals("+")){
			result=num1+num2;
		}else{
			if(oper.equals("-")){
				result=num1-num2;}else{
					if(oper.equals("*")){
						result=num1*num2;
					}else{
						result=num1/num2;
					}	
				}
		}
		return result;
	}

}
