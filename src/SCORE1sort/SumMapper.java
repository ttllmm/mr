package SCORE1sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SumMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] arr = value.toString().split(" ");
		context.write(new Text(new Text(arr[0])+"\t"+new Text(arr[1])), new IntWritable(Integer.parseInt(arr[2])));
		

	}

}
