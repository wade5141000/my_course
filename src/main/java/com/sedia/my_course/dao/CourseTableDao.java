package com.sedia.my_course.dao;

import com.sedia.my_course.model.CourseTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTableDao extends JpaRepository<CourseTable, Integer> {


}