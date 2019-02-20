package profit;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class profitMapper extends Mapper<LongWritable, Text, IntWritable,Profit> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//		获取一行数据
      String line = value.toString();
//      
      String[] arr = line.split(" ");
      Profit f=new Profit();
      f.setMonth(Integer.parseInt(arr[0]));
      f.setName(arr[1]);
      f.setIncome(Integer.parseInt(arr[2]));
      f.setExpense(Integer.parseInt(arr[3]));
      context.write(new IntWritable(f.getMonth()), f);
	}

}
