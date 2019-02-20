package sortProfit;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class Profit implements WritableComparable<Profit>{
	private int month;
	private String name=" ";
	private int profit;
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.month=in.readInt();
		this.name=in.readUTF();
		this.profit=in.readInt();
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(month);
		out.writeUTF(name);
		out.writeInt(profit);
		
	}
	@Override
	public int compareTo(Profit o) {
		int i=this.month-o.month;
		if(i==0){
			int j=this.profit-o.profit;
			if(j==0){
				return -1;
			}
			else {
				return j;
			}
		}
		return i;
	}
	@Override
	public String toString() {
		return "Profit [month=" + month + ", name=" + name + ", profit=" + profit + "]";
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
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}

}
