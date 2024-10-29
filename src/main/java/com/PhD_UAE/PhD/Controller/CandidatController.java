/*package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.CandidatDTO;
import com.PhD_UAE.PhD.Service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/phd/candidat")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @PostMapping("/create/{userId}")
    public String createCandidat(@RequestBody CandidatDTO candidatDTO, @PathVariable Long userId) {
        return candidatService.createCandidat(candidatDTO, userId);
    }
}*/
package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.CandidatDTO;
import com.PhD_UAE.PhD.Service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/phd/candidat")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @PostMapping("/create/{userId}")
    public String createCandidat(@Validated @RequestBody CandidatDTO candidatDTO, @PathVariable Long userId) {
        return candidatService.createCandidat(candidatDTO, userId);
    }
}

