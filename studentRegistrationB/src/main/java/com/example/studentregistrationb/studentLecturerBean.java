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

@Stateless(name = "studentLecturerEJB")
public class studentLecturerBean {

    @EJB
    ConnectBean connectBean;
    public studentLecturerBean() {
    }

    public List<Map<String, String>> getMyBar4() {
        Connection connection = connectBean.getConnection();
        List<Map<String, String>> myBar4 = new ArrayList<>();

        try {
            String sql = "SELECT ld.lecturer_name, COUNT(DISTINCT s.student_id) AS total_students\n" +
                    "                    FROM enrollment e\n" +
                    "                    JOIN student_dim s ON e.student_id = s.student_id\n" +
                    "                    JOIN modules m ON e.course_id = m.course_id\n" +
                    "                    JOIN lecturers_dim ld ON m.lecturer_id = ld.lecturer_id\n" +
                    "                    GROUP BY ld.lecturer_name\n" +
                    "                    ORDER BY ld.lecturer_name ASC";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, String> myBarD = new HashMap<>();
                myBarD.put("lecturerName", resultSet.getString("LECTURER_NAME"));
                myBarD.put("totalStudents", resultSet.getString("TOTAL_STUDENTS"));

                myBar4.add(myBarD);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myBar4;
    }
}
