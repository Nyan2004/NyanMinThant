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

@Stateless(name = "lecturerListEJB")
public class lecturerListBean {

    @EJB
    ConnectBean connectBean;
    public lecturerListBean() {
    }
    public List<Map<String, String>> getMyBar8() {
        Connection connection = connectBean.getConnection();
        List<Map<String, String>> myBar8 = new ArrayList<>();

        try {
            String sql = "SELECT ld.lecturer_name, m.module_name\n" +
                    "FROM modules m\n" +
                    "JOIN lecturers_dim ld ON m.lecturer_id = ld.lecturer_id";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, String> myBarH = new HashMap<>();
                myBarH.put("lecturerName", resultSet.getString("lecturer_name"));
                myBarH.put("moduleName", resultSet.getString("module_name"));

                myBar8.add(myBarH);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myBar8;
    }
}
