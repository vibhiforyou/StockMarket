package com.example.userprofile.model.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_profile")
@SuppressWarnings("unused")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class UserProfile{
        @Id
        @Column(name = "id") UUID id;

        @Column(name = "first_name")
        String firstName;

        @Column(name = "last_name")
        String lastName;

        @Column(name = "email")
        String email;

        @Column(name = "phone")
        String phone;

        @Column(name = "username")
        String username;

        @Column(name = "password")
        String password;

        @Column(name = "created")
        OffsetDateTime created;

        @Column(name = "updated")
        OffsetDateTime updated;

        @Column(name = "created_by")
        String createdBy;

        @Column(name = "updated_by")
        String updatedBy;

        public UUID getId() {
                return id;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public OffsetDateTime getCreated() {
                return created;
        }

        public void setCreated(OffsetDateTime created) {
                this.created = created;
        }

        public OffsetDateTime getUpdated() {
                return updated;
        }

        public void setUpdated(OffsetDateTime updated) {
                this.updated = updated;
        }

        public String getCreatedBy() {
                return createdBy;
        }

        public void setCreatedBy(String createdBy) {
                this.createdBy = createdBy;
        }

        public String getUpdatedBy() {
                return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
                this.updatedBy = updatedBy;
        }

        public UserProfile() {
        }

        public UserProfile(UUID id, String firstName, String lastName, String email, String phone, String username, String password, OffsetDateTime created, OffsetDateTime updated, String createdBy, String updatedBy) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
                this.phone = phone;
                this.username = username;
                this.password = password;
                this.created = created;
                this.updated = updated;
                this.createdBy = createdBy;
                this.updatedBy = updatedBy;
        }
}
