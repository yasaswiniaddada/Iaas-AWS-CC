package com.amazonaws.samples;

public class Main {
	public static void main(String[] args) {
//		DeepLearningInstance ec2eg = new DeepLearningInstance();
//		ec2eg.startInstance();
		
//		VideoRecording.RequestForVideo();
		
		InstanceHandler i = new InstanceHandler();
		i.createInstance("ami-0385455dc2b1498ef");
		i.listInstances();
	}
}
