package com.amazonaws.samples;

import java.util.List;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.*;

public class SQSHandler {
	private static final String QUEUE_NAME = "bbQueue";


    public static void createQueue() {
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        try {
            CreateQueueRequest createQueueRequest =
                    new CreateQueueRequest(QUEUE_NAME);
            String myQueueUrl = sqs.createQueue(createQueueRequest)
                    .getQueueUrl();
            System.out.println(myQueueUrl);
        } catch (AmazonSQSException e) {
            if (!e.getErrorCode().equals("QueueAlreadyExists")) {
                throw e;
            }
        }
    }

    public static void sendMsg() {
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        String queueUrl = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody("hello world")
                .withDelaySeconds(5);
        sqs.sendMessage(send_msg_request);
        System.out.println("send a msg");
    }

    public static void receiveMsg() {
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        String queueUrl = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();

        List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
        // delete messages from the queue
        for (Message m : messages) {
            sqs.deleteMessage(queueUrl, m.getReceiptHandle());

        }
        System.out.println("deleted msgs");
    }

}
