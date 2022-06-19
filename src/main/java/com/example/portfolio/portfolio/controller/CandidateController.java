package com.example.portfolio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.portfolio.portfolio.dto.CandidateDTO;
import com.example.portfolio.portfolio.service.CandidateService;
import com.example.portfolio.portfolio.utility.CandidateException;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

	@Autowired
	CandidateService candidateService;

	@PostMapping(value = "/add")
	public ResponseEntity<String> addCandidate(@RequestPart("request") CandidateDTO candidateDTO,
			@RequestPart("resume") MultipartFile resume) throws Exception {
		// creating post request for sending the file
		
		//creating headers with multipart form data
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		// creating multivalue map for storing mulitiple kind of requests
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		
		//serializing the resume multipart file so as to send through rest template
		ByteArrayResource fileAsResource = new ByteArrayResource(resume.getBytes()) {
			@Override
			public String getFilename() {
				return resume.getOriginalFilename();
			}
		};
		
		//adding file and email id to map
		body.add("resume", fileAsResource);
		body.add("emailId", candidateDTO.getEmailId());
		
		// creating the final http request from body and headers 
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

		// setting up the end point for rest template
		String serverUrl = "http://localhost:8090/resume/upload";

		// creating rest template object
		RestTemplate restTemplate = new RestTemplate();
		
		// finding sending the http request though rest template
		String response = restTemplate.postForEntity(serverUrl, requestEntity, String.class).getBody();

		String response1 = candidateService.addCandidate(candidateDTO);

		return new ResponseEntity<String>(response + "\n" + response1, HttpStatus.CREATED);
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<CandidateDTO> getCandidate(@PathVariable Integer id) throws CandidateException {
		return new ResponseEntity<CandidateDTO>(candidateService.getCandidate(id), HttpStatus.OK);
	}

	@PostMapping(value = "/upload")
	public ResponseEntity<String> updloadResume(@RequestBody MultipartFile resume) {
		System.out.print(resume);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

}
