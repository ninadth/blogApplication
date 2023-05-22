package com.bikkadit.curdopration.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		// file name
		String name = file.getOriginalFilename();

		// abc.png

		// Random name generated file
		String string2 = UUID.randomUUID().toString();

		String fileName1 = string2.concat(name.substring(name.lastIndexOf(".")));

		// fullpath

		String filePath = path + File.separator + fileName1;

		// create a file if not created

		File f = new File(path);

		if (!f.exists()) {

			f.mkdir();
		}

		// file copy

		Files.copy(file.getInputStream(), Paths.get(filePath));

		return fileName1;
	}

	@Override
	public InputStream getResources(String path, String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String fullPath=path+File.separatorChar+fileName;
		InputStream is=new FileInputStream(fullPath);
		return is;
	}

}
