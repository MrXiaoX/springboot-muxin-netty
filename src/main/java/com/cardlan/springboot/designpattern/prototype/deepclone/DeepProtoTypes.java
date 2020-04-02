package com.cardlan.springboot.designpattern.prototype.deepclone;

import java.io.*;

public class DeepProtoTypes implements Serializable, Cloneable{

	public String name;
	public DeepCloneableTarget deepCloneableTarget;

	public DeepProtoTypes() {
		super();
	}

	//深拷贝-方式一 clone方法
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object deept;
		//这里完成对基本数据类型String的克隆
		deept=super.clone();
		//对引用类型的属性，进行单独克隆
		DeepProtoTypes deepProtoTypes= (DeepProtoTypes) deept;
		deepProtoTypes.deepCloneableTarget= (DeepCloneableTarget) deepCloneableTarget.clone();

		return deepProtoTypes;
	}



	public Object deepClone(){
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos= null;
		ByteArrayInputStream bis= null;
		ObjectInputStream ois= null;
		DeepProtoTypes deepProtoTypes = null;
		try {
			//序列化
			bos=new ByteArrayOutputStream();
			oos=new ObjectOutputStream(bos);
			oos.writeObject(this);
			//反序列化
			bis=new ByteArrayInputStream(bos.toByteArray());
			ois=new ObjectInputStream(bis);
			deepProtoTypes= (DeepProtoTypes) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bos.close();
				oos.close();
				bis.close();
				ois.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return deepProtoTypes;
	}

}
