package score1sumbyMoth;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class flowMapper extends Mapper<LongWritable, Text, Text,Score> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//		获取一行数据
      String line = value.toString();
//      
      String[] arr = line.split(" ");
      Score f=new Score();
      f.setMonth(Integer.parseInt(arr[0]));
      f.setName(arr[1]);
      
      f.setScore(Integer.parseInt(arr[2]));
      
      context.write(new Text(f.getName()), f);
	}

}
