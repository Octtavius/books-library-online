package com.service.helpers;

import java.io.IOException;
import java.io.InputStream;

public abstract class File {

	public abstract String getContentType();

	public abstract long getContentLength();

	public abstract String getOriginalFileName();

	public abstract InputStream getInputStream() throws IOException;

}
