package SCORE1sort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class SScore implements WritableComparable<SScore>{
	private int month;
	private String name="";
	private int sumscore;
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.month=in.readInt();
		this.name=in.readUTF();
		this.sumscore=in.readInt();
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(month);
		out.writeUTF(name);
		out.writeInt(sumscore);
		
	}
	@Override
	public int compareTo(SScore o) {
		// TODO Auto-generated method stub
		int i=this.month-o.month;
		if(i==0){
			int j=this.sumscore-o.sumscore;
			if(j==0){
				return -1;
			}
			return j;
			
		}
		return i;
	}
	@Override
	public String toString() {
		return "SScore [month=" + month + ", name=" + name + ", sumscore=" + sumscore + "]";
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
	public int getSumscore() {
		return sumscore;
	}
	public void setSumscore(int sumscore) {
		this.sumscore = sumscore;
	}

}
