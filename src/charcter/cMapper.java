package charcter;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class cMapper extends Mapper<LongWritable, Text, Text,LongWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//		获取一行数据
		String line = value.toString();
//		拆分字符
		char[] cs = line.toCharArray();
		for(char c:cs){
			if(c==' ')
				continue;
			
			context.write(new Text(c+""), new LongWritable(1));
		}

	}

}
