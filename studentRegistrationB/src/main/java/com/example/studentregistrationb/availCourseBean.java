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

@Stateless(name = "availCourseEJB")
public class availCourseBean {

  @EJB
  ConnectBean connectBean;
    public availCourseBean() {
    }

  public List<Map<String, String>> getMyBar6() {
    Connection connection = connectBean.getConnection();
    List<Map<String, String>> myBar6 = new ArrayList<>();

    try {
      String sql = "SELECT c.course_name, m.module_name\n" +
              "FROM courses c\n" +
              "JOIN modules m ON c.course_id = m.course_id\n" +
              "ORDER BY c.course_id, m.module_name\n";

      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Map<String, String> myBarF = new HashMap<>();
        myBarF.put("courseName", resultSet.getString("course_name"));
        myBarF.put("moduleName", resultSet.getString("module_name"));

        myBar6.add(myBarF);
      }

      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return myBar6;
  }
}
