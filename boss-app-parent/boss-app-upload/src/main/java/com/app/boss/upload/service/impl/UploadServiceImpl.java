package com.app.boss.upload.service.impl;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.boss.upload.service.UploadService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
@Service
public class UploadServiceImpl implements UploadService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadServiceImpl.class);
	
	@Autowired
	private FastFileStorageClient fileStorageClient;
	
	private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg");

	@Override
	public String uploadImage(MultipartFile file) {
		try {
			String type = file.getContentType();
			if(!suffixes.contains(type)) {
				LOGGER.info("upload file fail, the file type is mismatched: {}", type);
				return null;
			}
			BufferedImage image = ImageIO.read(file.getInputStream());
			if(image == null) {
				LOGGER.info("upload file fail, the file content is not suitable");
				return null;
			}
			StorePath storePath = fileStorageClient.uploadFile(file.getInputStream(), file.getSize(), StringUtils.substringAfterLast(file.getOriginalFilename(), "."), null);
			return storePath.getFullPath();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

}
