package scoresumonetxt;

import java.io.IOException;

import org.apache.commons.lang.Validate;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class sumReducer extends Reducer<Text, Score, Text, IntWritable> {

	
	
	public void reduce(Text key, Iterable<Score> values, Context context) throws IOException, InterruptedException {
//		LongWritable max=new LongWritable(0);
//		在进行遍历的时候，hadoop为了节省空间采用的是地址复用技术
//		key=bob
//		itarable：684 340 312 548
//      val.set(684);
//		val.set(340);
//		for (LongWritable val : values) {
//			if(val.get()>max.get()){
////				赋值的是地址
//				max=val;
//			}
		int sum=0;
		for(Score val:values){
			
				sum+=val.getValue1()+val.getValue2()+val.getValue3();
		}
		context.write(key, new IntWritable(sum));
	}

}
