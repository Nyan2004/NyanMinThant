package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Stateless(name = "totalStudentEJB")
public class totalStudentBean {

    @EJB
    ConnectBean connectBean;
    public totalStudentBean() {
    }
    public int getMybar9() {
        Connection connection = connectBean.getConnection();
        int myBar9 = 0;
        try {
            // Prepare the SQL query
            String sql = "SELECT COUNT(*) AS total_enrollments FROM student_dim";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Retrieve the total student count
            if (resultSet.next()) {
                myBar9 = resultSet.getInt("total_enrollments");
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myBar9;
    }
}
