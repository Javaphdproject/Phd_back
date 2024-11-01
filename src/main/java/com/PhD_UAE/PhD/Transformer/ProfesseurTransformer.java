package com.PhD_UAE.PhD.Transformer;

import com.PhD_UAE.PhD.Dto.ProfesseurDTO;
import com.PhD_UAE.PhD.Entity.Professeur;
import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Entity.UserType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ProfesseurTransformer extends Transformer<Professeur, ProfesseurDTO> {

    private final PasswordEncoder passwordEncoder;

    public ProfesseurTransformer(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Professeur toEntity(ProfesseurDTO dto) {
        Professeur professeur = new Professeur();
        professeur.setAdresse(dto.getAdresse());
        professeur.setGrade(dto.getGrade());

        User user = new User();
        user.setPrenom(dto.getPrenom());
        user.setNom(dto.getNom());
        user.setEmail(dto.getEmail());
        user.setTel(dto.getTel());
        user.setUserType(UserType.PROFESSEUR);
        user.setMdp(passwordEncoder.encode(dto.getPassword()));

        professeur.setUser(user);
        return professeur;
    }

    @Override
    public ProfesseurDTO toDTO(Professeur entity) {
        return new ProfesseurDTO(entity);
    }
}
