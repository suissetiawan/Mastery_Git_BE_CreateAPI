package com.dibimbing.assignmentDay20.dto;

public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String address;
    private Integer age;

    public UserResponseDTO() {}

    public UserResponseDTO(Long id, String username, String email, String address, Integer age) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.address = address;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
