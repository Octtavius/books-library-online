package com.service;

import java.io.IOException;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.service.helpers.File;

public class S3Service implements IObjectService{

    private static final String bucketName = "books-library-morcov";
	private AmazonS3 s3client;
	
	public S3Service(String accessKey, String secretKey) {
		AWSCredentials credentials = new BasicAWSCredentials(
				  accessKey, secretKey
				);
		
		 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.EU_WEST_1)
				  .build();
	}

	@Override
	public Object uploadObject(String path, File file) throws Exception {
		ObjectMetadata metadata = new ObjectMetadata();

	    metadata.setContentType(file.getContentType());
	    metadata.setContentLength(file.getContentLength());
	    
	    try {
			return s3client.putObject(bucketName, path, file.getInputStream(), metadata);
		} catch (SdkClientException | IOException e) {
			throw new Exception(e);
		}
	}

	@Override
	public Object getFile(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

}
