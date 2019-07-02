package com.app.boss.upload.web;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.boss.upload.service.UploadService;


@RestController
@RequestMapping("upload")
public class UploadController {
	
	@Autowired
	private UploadService uploadService;
	
	@Value("${fdfs.base_url}")
	private String baseUrl;
	
	@PostMapping(value="image", headers="Content-Type=multipart/form-data")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file){
		String url = uploadService.uploadImage(file);
		if(StringUtils.isEmpty(url)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.ok(baseUrl + url);
	}

}
