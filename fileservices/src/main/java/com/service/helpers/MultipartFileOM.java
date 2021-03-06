package com.service.helpers;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileOM extends File{

	MultipartFile file;

	public MultipartFileOM(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String getContentType() {
		return file.getContentType();
	}

	@Override
	public long getContentLength() {
		return file.getSize();
	}

	@Override
	public String getOriginalFileName() {
		return file.getOriginalFilename();
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return file.getInputStream();
	}
}
