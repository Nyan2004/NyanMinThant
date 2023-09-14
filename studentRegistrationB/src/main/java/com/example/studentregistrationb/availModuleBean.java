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

@Stateless(name = "availModuleEJB")
public class availModuleBean {

  @EJB
  ConnectBean connectBean;
    public availModuleBean() {
    }

  public List<Map<String, String>> getMyBar7() {
    Connection connection = connectBean.getConnection();
    List<Map<String, String>> myBar7 = new ArrayList<>();

    try {
      String sql = "SELECT \n" +
              "    m.course_id,\n" +
              "    l.lecturer_name,\n" +
              "    COUNT(e.enrollment_id) AS total_enrollments\n" +
              "FROM \n" +
              "    enrollment e\n" +
              "JOIN \n" +
              "    modules m ON e.course_id = m.course_id\n" +
              "JOIN \n" +
              "    lecturers_dim l ON m.lecturer_id = l.lecturer_id\n" +
              "GROUP BY\n" +
              "    m.course_id, l.lecturer_id, l.lecturer_name\n" +
              "ORDER BY \n" +
              "    total_enrollments DESC\n" +
              "FETCH FIRST 5 ROWS ONLY\n";

      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Map<String, String> myBarG = new HashMap<>();
        myBarG.put("lecturerName", resultSet.getString("lecturer_name"));
        myBarG.put("totalEnrollments", resultSet.getString("total_enrollments"));

        myBar7.add(myBarG);
      }

      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return myBar7;
  }
}
