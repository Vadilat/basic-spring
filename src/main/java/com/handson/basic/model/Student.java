package com.handson.basic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.handson.basic.util.Dates;
import org.hibernate.validator.constraints.Length;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id//under id it primary key
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull//under it cannot be empty
    @Column(nullable = false, updatable = false)
    private Date createdAt = Dates.nowUTC();

    @NotEmpty
    @Length(max = 60)
    private String fullname;

    private Date birthDate;

    @Min(100)
    @Max(800)
    private Integer satScore;

    @Min(30)
    @Max(110)
    private Double graduationScore;

    @Length(max = 20)
    private String phone;

    @Length(max = 100)
    private String email;

    @Length(max = 500)
    private String profilePicture;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdAt")
    public LocalDateTime calcCreatedAt() {
        return Dates.atLocalTime(createdAt);
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("birthDate")
    public LocalDateTime calcBirthDate() {
        return Dates.atLocalTime(birthDate);
    }
    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getSatScore() {
        return satScore;
    }

    public void setSatScore(Integer satScore) {
        this.satScore = satScore;
    }

    public Double getGraduationScore() {
        return graduationScore;


    }

    public void setGraduationScore(Double graduationScore) {
        this.graduationScore = graduationScore;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public String getEmail( ){return email;}
    public void setEmail(String phone) {
        this.email = phone;
    }

    public static final class StudentBuilder {
        private Long id;
        private @NotNull Date createdAt;
        private @NotEmpty @Length(max = 60) String fullname;
        private Date birthDate;
        private @Min(100) @Max(800) Integer satScore;
        private @Min(30) @Max(110) Double graduationScore;
        private @Length(max = 20) String phone;
        private @Length(max = 100) String email;
        private @Length(max = 500) String profilePicture;

        private StudentBuilder() {
        }

        public static StudentBuilder aStudent() {
            return new StudentBuilder();
        }

        public StudentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty("createdAt")
        public LocalDateTime calcCreatedAt() {
            return Dates.atLocalTime(createdAt);
        }

        public StudentBuilder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public StudentBuilder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @JsonProperty("birthDate")
        public LocalDateTime calcBirthDate() {
            return Dates.atLocalTime(birthDate);
        }

        public StudentBuilder satScore(Integer satScore) {
            this.satScore = satScore;
            return this;
        }

        public StudentBuilder graduationScore(Double graduationScore) {
            this.graduationScore = graduationScore;
            return this;
        }

        public StudentBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public StudentBuilder profilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
            return this;
        }

        public StudentBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.setId(id);
            student.setCreatedAt(createdAt);
            student.setFullname(fullname);
            student.setBirthDate(birthDate);
            student.setSatScore(satScore);
            student.setGraduationScore(graduationScore);
            student.setPhone(phone);
            student.setEmail(email);
            student.setProfilePicture(profilePicture);
            return student;
        }
    }
}