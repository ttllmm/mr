package sortProfit;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import scorelist.Score;

public class SPDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "JobName");
		job.setJarByClass(sortProfit.SPDriver.class);
		// TODO: specify a mapper
		job.setMapperClass(SPMapper.class);
		// TODO: specify a reducer
		job.setReducerClass(SPReducer.class);

		// TODO: specify output types
//		job.setMapOutputKeyClass(Profit.class);
//		job.setMapOutputKeyClass(NullWritable.class);
		job.setOutputKeyClass(Profit.class);
		job.setOutputValueClass(NullWritable.class);

		// TODO: specify input and output DIRECTORIES (not files)
		FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.117.115:9000/mr/profit.txt"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.117.115:9000/SPprofit111111-result"));

		if (!job.waitForCompletion(true))
			return;
	}

}
