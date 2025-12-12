package com.dibimbing.assignmentDay20.dto;

public class RegisterRequestDTO {
    
    private String username;
    private String email;
    private String password;
    private String address;
    private Integer age;

    public RegisterRequestDTO() {}

    public RegisterRequestDTO(String username, String email, String password, String address, Integer age) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
