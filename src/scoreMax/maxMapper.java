package scoreMax;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class maxMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//		获取一行数据
      String line = value.toString();
//      
      String[] arr = line.split(" ");
      context.write(new Text(arr[0]), new LongWritable(Long.parseLong(arr[1])));
	}

}
