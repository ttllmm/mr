package profit;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class profitDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "JobName");
		job.setJarByClass(profit.profitDriver.class);
		// TODO: specify a mapper
		job.setMapperClass(profitMapper.class);
		// TODO: specify a reducer
		job.setReducerClass(profitReducer.class);
//		设置分区类
		job.setPartitionerClass(profitPartioner.class);
//		根据分区数量设置reducetask数量
//		如果reducetask的数量为1分区无效
		job.setNumReduceTasks(3);

		// TODO: specify output types
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Profit.class);
		
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);

		// TODO: specify input and output DIRECTORIES (not files)
		FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.117.115:9000/mr/profit.txt"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.117.115:9000/profit-result"));

		if (!job.waitForCompletion(true))
			return;
	}

}
