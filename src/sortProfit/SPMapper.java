package sortProfit;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SPMapper extends Mapper<LongWritable, Text, Profit, NullWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] line = value.toString().split(" ");
		Profit profit=new Profit();
		profit.setMonth(Integer.parseInt(line[0]));
		profit.setName(line[1]);
		profit.setProfit(Integer.parseInt(line[2]));
		context.write(profit, NullWritable.get());

	}

}
