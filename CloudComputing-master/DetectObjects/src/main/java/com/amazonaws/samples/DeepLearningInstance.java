package com.amazonaws.samples;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.StartInstancesRequest;

public class DeepLearningInstance {
	public void startInstance() {
		final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();
		StartInstancesRequest request = new StartInstancesRequest().withInstanceIds("i-0c3631359b61d1336");
		ec2.startInstances(request);
	}
}
