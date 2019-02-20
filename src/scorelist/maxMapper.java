package scorelist;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class maxMapper extends Mapper<LongWritable, Text, Score,NullWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//		��ȡһ������
      String line = value.toString();
//      
      String[] arr = line.split(" ");
      Score score=new Score();
      score.setName(arr[0]);
      score.setScore(Integer.parseInt(arr[1]));
      context.write(score, NullWritable.get());
	}

}
