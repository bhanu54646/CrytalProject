package org.example.repository;

import org.example.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    @Query("select p from StudentEntity p where p.firstName=?1")
    public List<StudentEntity> findStudentById(String firstName);
    @Modifying
    @Transactional
    @Query("delete  from StudentEntity s where s.firstName=?1")
    public int deleteStudentByName(String firstName);
    @Query("select p from StudentEntity p where p.id=?1")
    public StudentEntity findStudentById(long id);
    @Query("select p from StudentEntity p where p.id=?1")
    public List<StudentEntity> findStudent(long id);

}
