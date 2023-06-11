package com.example.userprofile.repository;

import com.example.userprofile.model.bo.UserProfile;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {

    @Query("SELECT userProfile FROM UserProfile userProfile")
    List<UserProfile> getAllUserProfiles();


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_profile(first_name,last_name,email,phone,username,password,created,updated,created_by,updated_by) VALUES (:firstName,:lastName,:email,:phone,:username,:password,:created,:updated,:created_by,:updated_by)", nativeQuery = true)
    void saveUserProfile(
            @Param("firstName")
            String firstName,

            @Param("lastName")
            String lastName,

            @Param("email")
            String email,

            @Param("phone")
            String phone,

            @Param("username")
            String username,

            @Param("password")
            String password,
            @Param("created")
            OffsetDateTime created,

            @Param("updated")
            OffsetDateTime updated,

            @Param("created_by")
            String created_by,

            @Param("updated_by")
            String updated_by
    );

    @Query(value = "SELECT count(*) FROM user_profile WHERE username=:username", nativeQuery = true)
    int getUsernameCount(@Param("username") String username);

    @Query(value = "SELECT count(*) FROM user_profile WHERE email=:email", nativeQuery = true)
    int getEmailCount(@Param("email") String email);

    @Query(value = "SELECT count(*) FROM user_profile WHERE phone=:phone", nativeQuery = true)
    int getPhoneCount(@Param("phone") String username);
}
