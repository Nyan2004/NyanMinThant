package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless(name = "enrollPerCourseEJB")
public class enrollPerCourseBean {

  @EJB
  ConnectBean connectBean;

  public enrollPerCourseBean() {
    }

  public List<Map<String, String>> getMyBar1() {
    Connection connection = connectBean.getConnection();
    List<Map<String, String>> myBar1 = new ArrayList<>();

    try {
      String sql = "SELECT c.course_id, COUNT(DISTINCT e.student_id) AS total_enrollment\n" +
              "FROM courses_dim c \n" +
              "LEFT JOIN enrollment e ON c.course_id = e.course_id\n" +
              "GROUP BY c.course_id\n" +
              "ORDER BY c.course_id ASC";

      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Map<String, String> myBar = new HashMap<>();
        myBar.put("courseId", resultSet.getString("course_id"));
        myBar.put("totalEnrollment", resultSet.getString("total_enrollment"));

        myBar1.add(myBar);
      }

      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return myBar1;
  }
}
