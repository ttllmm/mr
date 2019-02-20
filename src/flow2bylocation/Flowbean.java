package flow2bylocation;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class Flowbean implements Writable{
	private String phone="";
	private String addr="";
	private String name="";
	private Integer flow;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFlow() {
		return flow;
	}
	public void setFlow(Integer flow) {
		this.flow = flow;
	}
	@Override
//	反序列化
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.phone = in.readUTF();
		this.addr=in.readUTF();
		this.name=in.readUTF();
		this.flow=in.readInt();
		
	}
	@Override
//	序列化
	public void write(DataOutput out) throws IOException {
		out.writeUTF(phone);
		out.writeUTF(addr);
		out.writeUTF(name);
		out.writeInt(flow);
		
		
	}

}
