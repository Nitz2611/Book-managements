package com.api.book.bootrestbook.helper;

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

	//public final String UPLOAD_DIR="C:\\Users\\sharm\\OneDrive\\Desktop\\springboot-projects\\bootrestbook\\src\\main\\resources\\static\\image";
	
	//dynamic path now we can change system and doesnt have to change the path
	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException
	{
		
	}
	public boolean uploadFile(MultipartFile f) {
		
		boolean f1=false;
		try {
			//
//			InputStream is = f.getInputStream();
//			byte data[]=new byte[is.available()];
//			
//			is.read(data);
//			
//			//write
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+f.getOriginalFilename());
//			
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
			
			Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			f1=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f1;
	}
}
