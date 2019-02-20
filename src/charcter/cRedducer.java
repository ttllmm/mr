package charcter;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class cRedducer extends Reducer<Text, LongWritable, Text, LongWritable> {
//ע�⣺������ֻ�ܱ���һ��
	public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
		// process values
		long sum=0;
		for (LongWritable val : values) {
			sum+=val.get();

		}
		context.write(key, new LongWritable(sum));
	}

}
