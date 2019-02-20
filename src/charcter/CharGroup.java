package charcter;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparator;

public class CharGroup extends WritableComparator{
	@Override
	public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
		DataInput input1=new DataInputStream(new ByteArrayInputStream(b1));
		Text key1=new Text();
		try {
			key1.readFields(input1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		key1.set(b1,s1,l1);
		DataInput input2=new DataInputStream(new ByteArrayInputStream(b2));
		Text key2=new Text();
		try {
			key2.readFields(input2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		key2.set(b2,s2,l2);
		char c1 = key1.toString().charAt(0);
		char c2 = key2.toString().charAt(0);
//		判断c1和c2是否为小写字母
		if(c1>='a'&&c1<='z'&&c2>='a'&&c2<='z'){
			return 0;
			
		}
		else if(c1>='A'&&c1<='Z'&&c2>='A'&&c2<='Z'){
			return 0;
			
		}
		else return c1-c2;
	}

}
