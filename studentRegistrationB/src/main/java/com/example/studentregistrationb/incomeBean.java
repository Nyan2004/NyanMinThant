package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless(name = "incomeEJB")
public class incomeBean {

  @EJB
  ConnectBean connectBean;
    public incomeBean() {
    }

  public int getMybar11() {
    Connection connection = connectBean.getConnection();
    int myBar11 = 0;
    try {
      // Prepare the SQL query
      String sql = "SELECT SUM(fi.tution_fees) AS INCOME\n" +
              "    FROM fees_income fi";
      PreparedStatement statement = connection.prepareStatement(sql);

      // Execute the query
      ResultSet resultSet = statement.executeQuery();

      // Retrieve the total student count
      if (resultSet.next()) {
        myBar11 = resultSet.getInt("INCOME");
      }

      // Close the resources
      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return myBar11;
  }
}
