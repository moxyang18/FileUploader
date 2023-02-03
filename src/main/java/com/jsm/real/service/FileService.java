package com.jsm.real.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jsm.real.entity.File;

public interface FileService {
	public File uploadFile(MultipartFile uploadedFile) throws IOException;
	public List<File> getUploadHist();
}
