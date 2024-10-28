package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Repository.CandidatRepository;
import com.PhD_UAE.PhD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private UserRepository userRepository;

    public Candidat saveCandidat(Candidat candidat, Long userId) {
        // Find the user by ID
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        candidat.setUser(user); // Associate the User with the Candidat
        return candidatRepository.save(candidat); // Save the candidate
    }
}
