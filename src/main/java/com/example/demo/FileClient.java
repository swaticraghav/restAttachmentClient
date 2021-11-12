package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {

	public static void main(String[] args) throws FileNotFoundException {

		// Create the client
		// Tell the client which method it needs to use
		WebClient client = WebClient.create("http://localhost:7070/restattachment/services/fileservice/upload");
		// assign the type needed for attachment
		client.type("multipart/form-data");

		// Specify the type of the file the file that will sent and the name of the file
		ContentDisposition cd = new ContentDisposition("attachment;filename=Swati.jpg");
		// Create the attachment
		Attachment attachment = new Attachment("root",
				new FileInputStream(new File("C:/Users/swaragha/Desktop/Swati.jpg")), cd);
		// since uploading is post methid, call the post method and post attachment to it
		client.post(attachment);
		System.err.println("Client Success");
	}

}
