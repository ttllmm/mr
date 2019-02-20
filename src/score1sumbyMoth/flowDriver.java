package score1sumbyMoth;

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

public class flowDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "JobName");
		job.setJarByClass(score1sumbyMoth.flowDriver.class);
		// TODO: specify a mapper
		job.setMapperClass(flowMapper.class);
		// TODO: specify a reducer
		job.setReducerClass(flowReducer.class);
//		���÷�����
		job.setPartitionerClass(scorePartioner.class);
//		���ݷ�����������reducetask����
//		���reducetask������Ϊ1������Ч
		job.setNumReduceTasks(3);

		// TODO: specify output types
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Score.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		// TODO: specify input and output DIRECTORIES (not files)
		FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.117.115:9000/score1"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.117.115:9000/scorebymoth-result"));

		if (!job.waitForCompletion(true))
			return;
	}

}
