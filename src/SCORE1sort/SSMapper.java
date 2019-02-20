package SCORE1sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SSMapper extends Mapper<LongWritable, Text, SScore, NullWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		String[] arr = value.toString().split(" ");
		SScore score=new SScore();
		score.setMonth(Integer.parseInt(arr[0]));
		score.setName(arr[1]);
		score.setSumscore(Integer.parseInt(arr[2]));
		context.write(score, NullWritable.get());

	}

}
