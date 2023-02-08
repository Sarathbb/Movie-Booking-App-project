package com.apktl.uploadhelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	//public final String UPLOAD_DIR = "C:\\Users\\91940\\Documents\\workspace-sts-3.9.12.RELEASE\\Bookmyshow_clone_1\\src\\main\\resources\\static\\images";
	public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	public FileUploadHelper()throws IOException
	{
		
	}
	
	public boolean uploadFile(MultipartFile mpf) {
		
		boolean b = false;
		
		try {
			Files.copy(mpf.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+mpf.getOriginalFilename()), StandardCopyOption.COPY_ATTRIBUTES);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		b = true;
		
		return b;
	}
}
