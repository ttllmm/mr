package score1sumbyMoth;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Array;

import org.apache.hadoop.io.Writable;

public class Score implements Writable{
	
	private int month;
	private String name="";
	private int score;

	@Override
	public void readFields(DataInput in) throws IOException {
		this.month=in.readInt();
		this.name=in.readUTF();
		this.score=in.readInt();
		
		
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(month);
		out.writeUTF(name);
		out.writeInt(score);
		
		
		
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int math) {
		this.month = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	

	

}
