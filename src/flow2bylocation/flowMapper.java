package flow2bylocation;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class flowMapper extends Mapper<LongWritable, Text, Text,Flowbean> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//		获取一行数据
      String line = value.toString();
//      
      String[] arr = line.split(" ");
      Flowbean f=new Flowbean();
      f.setPhone(arr[0]);
      f.setAddr(arr[1]);
      f.setName(arr[2]);
      f.setFlow(Integer.parseInt(arr[3]));
      
      context.write(new Text(f.getName()), f);
	}

}
