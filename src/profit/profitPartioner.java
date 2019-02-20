package profit;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class profitPartioner extends Partitioner<IntWritable, Profit>{

	@Override
	public int getPartition(IntWritable key, Profit value, int numPartions) {
		String name = value.getName();
		switch (name) {
		case "ls":
			return 0;
		case "zs":
			return 1;
		case "ww":
			return 2;
		default:
			return 3;
	}
	

}
}