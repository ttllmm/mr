package scoresumonetxt;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class sumMapper extends Mapper<LongWritable, Text, Text, Score> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//		获取一行数据
      String line = value.toString();
//      
      String[] arr = line.split(" ");
      Score score=new Score();
      score.setName(arr[0]);
      score.setValue1(Integer.parseInt(arr[1]));
      score.setValue2(Integer.parseInt(arr[2]));
      score.setValue3(Integer.parseInt(arr[3]));
      context.write(new Text(score.getName()),score);
	}

}
