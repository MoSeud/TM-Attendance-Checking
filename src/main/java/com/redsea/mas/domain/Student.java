package com.redsea.mas.domain;


import com.redsea.mas.validator.StudentPhone;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student extends Person {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    @NotBlank
    @Size(min = 9,max = 12)
    private String studentId;
    @NotBlank
    private String barCode;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate entry;
    @Transient
    private MultipartFile profilePicture;

    @StudentPhone
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="phone_id",nullable = true)
    private Phone phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<TmCheckRetreat> tmCheckRetreatList = new ArrayList<>();


   /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public List<TmCheckRetreat> getTmCheckRetreatList() {
        return tmCheckRetreatList;
    }

    public void setTmCheckRetreatList(List<TmCheckRetreat> tmCheckRetreatList) {
        this.tmCheckRetreatList = tmCheckRetreatList;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public LocalDate getEntry() {
        return entry;
    }

    public void setEntry(LocalDate entry) {
        this.entry = entry;
    }

    public MultipartFile getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
