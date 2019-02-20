package flow2bylocation;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class flowReducer extends Reducer<Text, Flowbean, Text, IntWritable> {

	
	
	public void reduce(Text key, Iterable<Flowbean> values, Context context) throws IOException, InterruptedException {
//		LongWritable max=new LongWritable(0);
//		�ڽ��б�����ʱ��hadoopΪ�˽�ʡ�ռ���õ��ǵ�ַ���ü���
//		key=bob
//		itarable��684 340 312 548
//      val.set(684);
//		val.set(340);
//		for (LongWritable val : values) {
//			if(val.get()>max.get()){
////				��ֵ���ǵ�ַ
//				max=val;
//			}
		int flow=0;
		for(Flowbean val:values){
			flow+=val.getFlow();
		}

		context.write(key, new IntWritable(flow));
	}

}
