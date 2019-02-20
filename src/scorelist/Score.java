package scorelist;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

public class Score implements WritableComparable<Score>{
	private String name;
	private int score;
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
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.name=in.readUTF();
		this.score=in.readInt();
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(name);
out.writeInt(score);		
	}
	@Override
//	 如果要进行升序排序，那么就是this和o、比较
//	如果想要降序，o和this比较
//	返回值》0，this排在o的后边
	
//	返回值《0.this拍在o的前边
//	拿当前对象和 指定参数比较
	public int compareTo(Score o) {
		
		return this.score-o.score;
//		return -(this.score-o.score);
	}
	@Override
	public String toString() {
		return "Score [name=" + name + ", score=" + score + "]";
	}
	
}
