package scorelist;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class maxReducer extends Reducer<Score, NullWritable, Score, NullWritable> {

	
	
	public void reduce(Score key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
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
		
		
		context.write(key, NullWritable.get());
	}

}
