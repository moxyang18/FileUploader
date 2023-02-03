package com.jsm.real.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jsm.real.dao.FileDao;
import com.jsm.real.entity.File;
import com.jsm.real.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileDao fileDao;
	
	@Override
	public File uploadFile(MultipartFile uploadedFile) throws IOException {
		String fileName = StringUtils.cleanPath(uploadedFile.getOriginalFilename());
		File toSave = new File();
		toSave.setFileName(fileName);
		toSave.setFileType(uploadedFile.getContentType());
		toSave.setUploadTime(null);
		toSave.setContent(uploadedFile.getBytes());
		return fileDao.save(toSave);
	}

	@Override
	public List<File> getUploadHist() {
		// TODO Auto-generated method stub
		return fileDao.findAll();
	}

}
