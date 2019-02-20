package flow2bylocation;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class flow2Partioner extends Partitioner<Text, Flowbean>{

	@Override
	public int getPartition(Text key, Flowbean value, int numPartions) {
		String addr = value.getAddr();
		switch (addr) {
		case "bj":
			return 0;
		case "sh":
			return 1;
		case "sz":
			return 2;
		default:
			return 3;
	}
	

}
}