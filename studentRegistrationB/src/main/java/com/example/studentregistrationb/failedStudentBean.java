package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless(name = "failedStudentEJB")
public class failedStudentBean {
    @EJB
    ConnectBean connectBean;
    public failedStudentBean() {
    }
    public int getMybar9( String year) {
        Connection connection = connectBean.getConnection();
        int myBar9 = 0;

        try {
            String sql = "SELECT\n" +
                    "    COUNT(DISTINCT mo.course_id) AS course_count_with_failures\n" +
                    "FROM\n" +
                    "    mark m\n" +
                    "JOIN\n" +
                    "    modules mo ON m.module_id = mo.module_id\n" +
                    "JOIN\n" +
                    "    enrollment e ON m.student_id = e.student_id AND mo.course_id = e.course_id\n" +
                    "WHERE\n" +
                    "    m.status = 'Fail'\n" +
                    "    AND e.enrollment_year = ?";


            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, year);
            ResultSet resultSet = statement.executeQuery();

            // Retrieve the total student count
            if (resultSet.next()) {
                myBar9 = resultSet.getInt("course_count_with_failures");
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

