package com.perfectJava.repository;

import com.perfectJava.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepo extends JpaRepository<UserProfile,Long> {

}
