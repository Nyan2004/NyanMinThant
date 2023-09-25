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

@Stateless(name = "userCheckEJB")
public class userCheckBean {
    @EJB
    ConnectBean connectBean;

    public userCheckBean() {
    }

    // Retrieve individual student information by Email.
    public List<Map<String, String>> getUser(String email, String password) {
        Connection connection = connectBean.getConnection();
        List<Map<String, String>> dashboard = new ArrayList<>();

        try {
            // Prepare the SQL query with parameterized query
            String sql = "SELECT * FROM APP_USER WHERE EMAIL = ? AND PASSWORD = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set and extract data
            while (resultSet.next()) {
                Map<String, String> user = new HashMap<>();
                user.put("userId", resultSet.getString("USER_ID"));
                user.put("email", resultSet.getString("EMAIL"));
                dashboard.add(user);
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
        }

        return dashboard;
    }


    public List<Map<String, String>> getMyBar12() {
        Connection connection = connectBean.getConnection();
        List<Map<String, String>> myBar12 = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                    "    city,\n" +
                    "    COUNT(*) AS count\n" +
                    "FROM (\n" +
                    "    SELECT\n" +
                    "        REGEXP_SUBSTR(student_address, '[^,]+$', 1, 1) AS city\n" +
                    "    FROM\n" +
                    "        student\n" +
                    ") subquery\n" +
                    "GROUP BY\n" +
                    "    city\n" +
                    "ORDER BY\n" +
                    "    count DESC";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, String> myBarJ = new HashMap<>();
                myBarJ.put("city", resultSet.getString("city"));
                myBarJ.put("count", resultSet.getString("count"));

                myBar12.add(myBarJ);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myBar12;
    }

    public int getTotalModuleCount() {
        Connection connection = connectBean.getConnection();
        int totalModules = 0;
        try {
            // Prepare the SQL query
            String sql = "SELECT COUNT(*) AS total_modules FROM modules_dim";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Retrieve the total student count
            if (resultSet.next()) {
                totalModules = resultSet.getInt("total_modules");
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalModules;
    }

    public int getTotalTeacherCount() {
        Connection connection = connectBean.getConnection();
        int totalTeachers = 0;
        try {
            // Prepare the SQL query
            String sql = "SELECT COUNT(*) AS total_teachers FROM lecturers_dim";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Retrieve the total student count
            if (resultSet.next()) {
                totalTeachers = resultSet.getInt("total_teachers");
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalTeachers;
    }

    public int getTotalEnrollmentCount() {
        Connection connection = connectBean.getConnection();
        int totalEnrollments = 0;
        try {
            // Prepare the SQL query
            String sql = "SELECT COUNT(*) AS total_enrollments FROM enrollment";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Retrieve the total student count
            if (resultSet.next()) {
                totalEnrollments = resultSet.getInt("total_enrollments");
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalEnrollments;
    }

    //Query to retrieve student group by age
    public List<Map<String, String>> getStudentAgeDistribution() {
        Connection connection = connectBean.getConnection();
        List<Map<String, String>> ageDistributionList = new ArrayList<>();

        try {
            String sql = "SELECT age_group, COUNT(DISTINCT student_id) AS student_count " +
                    "FROM ( " +
                    "    SELECT CASE " +
                    "               WHEN (TRUNC(SYSDATE) - TRUNC(s.student_dob)) / 365 > 16 AND (TRUNC(SYSDATE) - TRUNC(s.student_dob)) / 365 <= 18 THEN '16-18' " +
                    "               WHEN (TRUNC(SYSDATE) - TRUNC(s.student_dob)) / 365 > 19 AND (TRUNC(SYSDATE) - TRUNC(s.student_dob)) / 365 <= 21 THEN '19-21' " +
                    "               WHEN (TRUNC(SYSDATE) - TRUNC(s.student_dob)) / 365 > 22 AND (TRUNC(SYSDATE) - TRUNC(s.student_dob)) / 365 <= 25 THEN '21-25' " +

                    "               ELSE '25+' " +
                    "           END AS age_group, " +
                    "           e.student_id " +
                    "    FROM enrollment e " +
                    "    JOIN student s ON e.student_id = s.student_id " +
                    ") age_counts " +
                    "GROUP BY age_group " +
                    "ORDER BY age_group";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, String> ageDistribution = new HashMap<>();
                ageDistribution.put("ageGroup", resultSet.getString("age_group"));
                ageDistribution.put("studentCount", resultSet.getString("student_count"));

                ageDistributionList.add(ageDistribution);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ageDistributionList;
    }
}

