package com.jsm.real.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jsm.real.entity.File;
import com.jsm.real.service.FileService;

@Controller
public class FileController extends BaseController {
	@Autowired
	FileService fileService;
	
	@RequestMapping("/uploadFile") 
	public String upload(@RequestParam("file") MultipartFile uploadedFile, Model model) {
		String retMsg = "";
		try {
			fileService.uploadFile(uploadedFile);
			retMsg = "Uploaded Successfully!";
			model.addAttribute("submit_res", retMsg);
		} catch (Exception e) {
			retMsg = "Error Uploading the File!";
			model.addAttribute("submit_res", retMsg);
		}		
		return "upload";
	}

	@RequestMapping("/upload") 
	public String uploadHist(Model model) {
		// TODO modify the hard coded limit
		List<File> fileHist = fileService.getUploadHist();
		model.addAttribute("fileHist", fileHist);
		return "upload";
	}	
	
}
