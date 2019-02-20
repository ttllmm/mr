package scoresumonetxt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Array;

import org.apache.hadoop.io.Writable;

public class Score implements Writable{
	public int getValue1() {
		return value1;
	}
	public void setValue1(int value1) {
		this.value1 = value1;
	}
	public int getValue2() {
		return value2;
	}
	public void setValue2(int value2) {
		this.value2 = value2;
	}
	public int getValue3() {
		return value3;
	}
	public void setValue3(int value3) {
		this.value3 = value3;
	}
	private String name="";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int value1;
	private int value2;
	private int value3;
	@Override
	public void readFields(DataInput in) throws IOException {
		this.name=in.readUTF();
		this.value1=in.readInt();
		this.value2=in.readInt();
		this.value3=in.readInt();
		
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(value1);
		out.writeInt(value2);
		out.writeInt(value3);
		
		
	}
	

	

}
