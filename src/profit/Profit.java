package profit;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Array;

import org.apache.hadoop.io.Writable;

public class Profit implements Writable{
	
	private int month;
	private String name="";
	private int income;
	private int expense;

	@Override
	public void readFields(DataInput in) throws IOException {
		this.month=in.readInt();
		this.name=in.readUTF();
		this.income=in.readInt();
		this.expense=in.readInt();
		
		
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(month);
		out.writeUTF(name);
		out.writeInt(income);
		out.writeInt(expense);
		
		
		
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}

	

	

}
