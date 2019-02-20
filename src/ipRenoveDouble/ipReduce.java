package ipRenoveDouble;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ipReduce extends Reducer<Text, LongWritable, Text, NullWritable> {

	public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
		// process values
		
		
		context.write(key, NullWritable.get());
	}

}
