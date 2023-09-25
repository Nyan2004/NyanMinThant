package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless(name = "passedStudentEJB")
public class passedStudentBean {
    @EJB
    ConnectBean connectBean;

    public passedStudentBean() {
    }
        public int getMybar11 (String year){
            Connection connection = connectBean.getConnection();
            int myBar11 = 0;

            try {
                String sql = "SELECT\n" +
                        "    (SELECT COUNT(DISTINCT e.student_id)\n" +
                        "     FROM enrollment e\n" +
                        "     WHERE e.enrollment_year = ?) -\n" +
                        "    \n" +
                        "    (SELECT COUNT(DISTINCT mo.course_id) \n" +
                        "     FROM mark m\n" +
                        "     JOIN modules mo ON m.module_id = mo.module_id\n" +
                        "     JOIN enrollment e ON m.student_id = e.student_id AND mo.course_id = e.course_id\n" +
                        "     WHERE m.status = 'Fail' AND e.enrollment_year = ?) AS total_passed_students\n" +
                        "FROM dual";


                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, year);
                statement.setString(2, year);
                ResultSet resultSet = statement.executeQuery();

                // Retrieve the total student count
                if (resultSet.next()) {
                    myBar11 = resultSet.getInt("total_passed_students");
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

