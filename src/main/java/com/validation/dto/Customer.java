package com.validation.dto;


import com.validation.annotation.NoHtml;
import com.validation.annotation.Phone;
import com.validation.group.UpdateInfo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Customer {

    @NotNull(groups = UpdateInfo.class,message = "id can not be null")
    private Long id;

    @NotBlank(message = "Name can not be null/blank")
    @NoHtml
    private String name;

    @Email
    private String email;

    @NotNull(message = "Location can not be null")
    @NoHtml
    private String location;

    @Phone
    private String phone;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }
}
