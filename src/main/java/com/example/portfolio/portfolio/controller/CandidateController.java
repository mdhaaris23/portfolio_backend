package com.example.portfolio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfolio.portfolio.dto.CandidateDTO;
import com.example.portfolio.portfolio.service.CandidateService;
import com.example.portfolio.portfolio.utility.CandidateException;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

	@Autowired
	CandidateService candidateService;

	@PostMapping(value = "/add")
	public ResponseEntity<String> addCandidate(@RequestBody CandidateDTO candidateDTO) {
		return new ResponseEntity<String>(candidateService.addCandidate(candidateDTO), HttpStatus.CREATED);
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<CandidateDTO> getCandidate(@PathVariable Integer id) throws CandidateException {
		return new ResponseEntity<CandidateDTO>(candidateService.getCandidate(id), HttpStatus.OK);
	}

}
