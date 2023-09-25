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

@Stateless(name = "registerEJB")
public class registerBean {
  @EJB
  ConnectBean connectBean;
    public registerBean() {
    }
  public void createUser(String email,String password) {
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      // Get the database connection
      connection = connectBean.getConnection();

      // Prepare the SQL query to Register a new student
      String sql = "INSERT INTO APP_USER (EMAIL, PASSWORD) VALUES (?, ?)";
      statement = connection.prepareStatement(sql);
      statement.setString(1, email);
      statement.setString(2, password);


      // Execute the query
      int rowsAffected = statement.executeUpdate();

      if (rowsAffected > 0) {
        // Close the resources
        statement.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
  }
}
