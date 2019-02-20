package sortProfit;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SPReducer extends Reducer<Profit, NullWritable, Profit, NullWritable> {

	public void reduce(Profit key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
		// process values
		context.write(key, NullWritable.get());
	}

}
