package com.service;

import com.service.helpers.File;

public interface IObjectService {

	/**
	 * return type is Object because for each implementation it can be different type
	 */
	public Object uploadObject(String path, File file) throws Exception;
	public Object getFile(String filePath);
}
