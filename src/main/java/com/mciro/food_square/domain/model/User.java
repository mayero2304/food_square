package com.mciro.food_square.domain.model;

// import com.mciro.food_square.domain.exception.DomainException;

public class User {
    private Long id;
    private String name;
    private String lastname;
    private Integer nit;
    private String phone;
    private String email;
    private String password;
    private Long role_id;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public User() {
    }

    public User(Long id, Long role_id, String name, String lastname, Integer nit, String phone, String email,
            String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.nit = nit;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role_id = role_id;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* validations */
    // private String emptyStringValidate(String data){
    // if(data.isEmpty()){
    // throw new DomainException("El campó no puede estar vacio");
    // }
    // return data;
    // }

    // private String cellphoneValidate(String cellphone) {
    // Pattern pattern = Pattern
    // .compile("/\+?+(0-9)+/");
    // Matcher matcher = pattern.matcher(cellphone);
    // if (!matcher.find()){
    // throw new DomainException("El formato celular es invalido");
    // }
    // if(cellphone.length()>13){
    // throw new DomainException("El numero de celular supera el espacio
    // permitido");
    // }
    // return cellphone;
    // }

    // private String nitValidate(String nit) {
    // Pattern pattern = Pattern
    // .compile("/(0-9)/");
    // Matcher matcher = pattern.matcher(nit);
    // if (!matcher.find()){
    // throw new DomainException("El formato cedula es invalido");
    // }

    // return nit;
    // }

    // private String emailValidate(String email) {
    // Pattern pattern = Pattern
    // .compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
    // Matcher matcher = pattern.matcher(email);
    // if (!matcher.find()) {
    // throw new DomainException("El formato correo es invalido");
    // }
    // return email;
    // }
}
