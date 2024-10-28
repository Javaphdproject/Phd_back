package com.PhD_UAE.PhD.Transformer;

import com.PhD_UAE.PhD.Dto.UserDTO;
import com.PhD_UAE.PhD.Entity.User;
import org.springframework.stereotype.Component;

@Component


public class UserTransformer extends Transformer<User, UserDTO> {


    @Override
    public User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        } else {
            User user = new User();
            user.setPrenom(dto.getPrenom());
            user.setNom(dto.getNom());
            user.setEmail(dto.getEmail());
            user.setMdp(dto.getMdp());
            user.setTel(dto.getTel());
            user.setUserType(dto.getUserType());

            return user;
        }
    }

    @Override
    public UserDTO toDTO(User entity) {
        if (entity == null) {
            return null;
        } else {
            UserDTO userDTO = new UserDTO();
            userDTO.setIdUser(entity.getIdUser());
            userDTO.setPrenom(entity.getPrenom());
            userDTO.setNom(entity.getNom());
            userDTO.setEmail(entity.getEmail());
            userDTO.setMdp(entity.getMdp());
            userDTO.setTel(entity.getTel());
            userDTO.setUserType(entity.getUserType()); // Corrigez cette ligne
            return userDTO;
        }
    }

}


