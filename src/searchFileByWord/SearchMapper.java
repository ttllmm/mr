package searchFileByWord;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class SearchMapper extends Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//		获取map对应的切片
		FileSplit split = (FileSplit) context.getInputSplit();
//		获取文件名
		String name = split.getPath().getName();
		String line = value.toString();
		String[] arr = line.split(" ");
		for(String a:arr){
			context.write(new Text(a),new Text(name));
		}
		
		
		

	}

}
