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

@Stateless(name = "registerYearEJB")
public class registerYearBean {

    @EJB
    ConnectBean connectBean;
    public registerYearBean() {
    }

    public List<Map<String, String>> getMyBar5() {
        Connection connection = connectBean.getConnection();
        List<Map<String, String>> myBar5 = new ArrayList<>();

        try {
            String sql = "SELECT academic_year, COUNT(DISTINCT student_id) AS total_students\n" +
                    "FROM (\n" +
                    "    SELECT enrollment_year AS academic_year, student_id\n" +
                    "    FROM enrollment\n" +
                    ") subquery\n" +
                    "GROUP BY academic_year\n" +
                    "ORDER BY academic_year";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, String> myBarE = new HashMap<>();
                myBarE.put("academicYear", resultSet.getString("ACADEMIC_YEAR"));
                myBarE.put("totalStudents", resultSet.getString("TOTAL_STUDENTS"));

                myBar5.add(myBarE);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myBar5;
    }
}
