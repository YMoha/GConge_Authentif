package com.example.authetificationconge.dto;

import lombok.Data;

import java.io.Serializable;


@Data
class FormUser implements Serializable {

        private String username;
        private String confirmedPassword;
        private String roleName;

}
