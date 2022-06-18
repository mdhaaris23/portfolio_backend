package com.example.portfolio.portfolio.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfolio.portfolio.dto.CandidateDTO;
import com.example.portfolio.portfolio.entity.Candidate;
import com.example.portfolio.portfolio.repository.CandidateRepository;
import com.example.portfolio.portfolio.utility.CandidateException;

@Service(value="candidateService")
@Transactional
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateRepository candidateRepo;

	@Override
	public String addCandidate(CandidateDTO candidateDTO) {
		candidateRepo.save(CandidateDTO.getCandidate(candidateDTO));
		return "Candidate successfully registered!! :)";
	}

	@Override
	public CandidateDTO getCandidate(Integer id) throws CandidateException {
		Optional<Candidate> rawCandidate = candidateRepo.findById(id);
		return Candidate.getCandidateDTO(rawCandidate.orElseThrow(() -> new CandidateException("Candidate does not exists")));
	}

}
