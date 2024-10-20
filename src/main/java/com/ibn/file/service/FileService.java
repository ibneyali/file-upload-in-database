package com.ibn.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ibn.file.entity.File;
import com.ibn.file.repository.FileRepository;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {
	@Autowired
	private FileRepository fileRepository;

	public File storeFile(MultipartFile file) throws IOException {
		File dbFile = new File();
		dbFile.setFileName(file.getOriginalFilename());
		dbFile.setFileType(file.getContentType());
		dbFile.setData(file.getBytes());
		return fileRepository.save(dbFile);
	}

	public Optional<File> getFile(Long fileId) {
		return fileRepository.findById(fileId);
	}

	public void deleteFile(Long fileId) {
		fileRepository.deleteById(fileId);
	}
}