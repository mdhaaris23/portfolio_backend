package com.example.portfolio.portfolio.service;

import com.example.portfolio.portfolio.dto.CandidateDTO;
import com.example.portfolio.portfolio.utility.CandidateException;

public interface CandidateService {

	public String addCandidate(CandidateDTO candidateDTO);
	public CandidateDTO getCandidate(Integer id) throws CandidateException;
	
}
