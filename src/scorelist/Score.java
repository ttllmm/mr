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
//	 ���Ҫ��������������ô����this��o���Ƚ�
//	�����Ҫ����o��this�Ƚ�
//	����ֵ��0��this����o�ĺ��
	
//	����ֵ��0.this����o��ǰ��
//	�õ�ǰ����� ָ�������Ƚ�
	public int compareTo(Score o) {
		
		return this.score-o.score;
//		return -(this.score-o.score);
	}
	@Override
	public String toString() {
		return "Score [name=" + name + ", score=" + score + "]";
	}
	
}
