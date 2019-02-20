package score1sumbyMoth;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class scorePartioner extends Partitioner<Text, Score>{

	@Override
	public int getPartition(Text key, Score value, int numPartions) {
		int month = value.getMonth();
		switch (month) {
		case 1:
			return 0;
		case 2:
			return 1;
		case 3:
			return 2;
		default:
			return 3;
	}
	

}
}