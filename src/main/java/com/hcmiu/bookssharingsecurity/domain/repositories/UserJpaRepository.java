package com.hcmiu.bookssharingsecurity.domain.repositories;

import com.hcmiu.bookssharingsecurity.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, String>, CrudRepository<User, String> {
    User findUserById(String id);
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByUsernameLike(String username);

    @Query("update User u set u.username = :username where u.id = :id")
    void updateUser(@Param("id") String id, @Param("username") String username);

    @Override
    <S extends User> S save(S entity);
}
