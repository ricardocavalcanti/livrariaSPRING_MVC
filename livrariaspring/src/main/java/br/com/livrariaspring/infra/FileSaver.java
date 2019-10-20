package br.com.livrariaspring.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	@Autowired
	private HttpServletRequest request;

	public String write(String baseFolder, MultipartFile sumario) {
		
		try {
			
			String realPath = request.getServletContext().getRealPath("/"+baseFolder);
			String pathname = realPath+"/"+sumario.getOriginalFilename();
			sumario.transferTo(new File(pathname));
			
		//	return pathname;
			return baseFolder + "/" + sumario.getOriginalFilename();
			
		} catch (IllegalStateException | IOException e) {
			
			throw new RuntimeException(e);
		}
		
	}
	
	
	
}
