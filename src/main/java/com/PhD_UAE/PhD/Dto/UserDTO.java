package com.PhD_UAE.PhD.Dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long idUser;
    private String role;
    private String email;
    private String mdp;
    private String login;
}
