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

@Stateless(name = "passModuleEJB")
public class passModuleBean {

  @EJB
  ConnectBean connectBean;
    public passModuleBean() {
    }

  public List<Map<String, String>> getMyBar2() {
    Connection connection = connectBean.getConnection();
    List<Map<String, String>> myBar2 = new ArrayList<>();

    try {
      String sql = "SELECT md.module_name, \n" +
              "       pass_counts.pass\n" +
              "FROM modules_dim md\n" +
              "LEFT JOIN (\n" +
              "    SELECT m.module_id, COUNT(*) AS pass\n" +
              "    FROM mark m\n" +
              "    WHERE m.status = 'Pass'\n" +
              "    GROUP BY m.module_id\n" +
              ") pass_counts ON md.module_id = pass_counts.module_id\n" +
              "ORDER BY md.module_id ASC";

      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Map<String, String> myBarB = new HashMap<>();
        myBarB.put("moduleName", resultSet.getString("MODULE_NAME"));
          myBarB.put("pass", resultSet.getString("PASS"));

        myBar2.add(myBarB);
      }

      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return myBar2;
  }
}
