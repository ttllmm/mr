package searchFileByWord;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SearchReducer extends Reducer<Text, Text, Text, Text> {

	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		StringBuilder sb = new StringBuilder();
		Set<String>set=new HashSet<>();
		for(Text val:values){
			
			set.add(val.toString());
			
		}
		for(String s:set){
			
			sb.append(s).append(" ");
		}
		context.write(key, new Text(sb.toString()));
	}

}
