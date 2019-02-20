package SCORE1sort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SSDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "JobName");
		job.setJarByClass(SCORE1sort.SSDriver.class);
		// TODO: specify a mapper
		job.setMapperClass(SumMapper.class);
		// TODO: specify a reducer
		job.setReducerClass(SumReducer.class);

		// TODO: specify output types
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		// TODO: specify input and output DIRECTORIES (not files)
		FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.117.115:9000/score1"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.117.115:9000/score-SumResult"));

		if (!job.waitForCompletion(true)){
			
			Job job2 = Job.getInstance(conf, "JobName");
		job2.setJarByClass(SCORE1sort.SSDriver.class);
		// TODO: specify a mapper
		job2.setMapperClass(SSMapper.class);
		
		job2.setOutputKeyClass(SScore.class);
		job2.setOutputValueClass(NullWritable.class);
		System.out.println("1111111111");
		// TODO: specify input and output DIRECTORIES (not files)
		FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.117.115:9000/score-SumResult"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.117.115:9000/score-SumResult"));

		job.waitForCompletion(true);
			
	}
	}

}
