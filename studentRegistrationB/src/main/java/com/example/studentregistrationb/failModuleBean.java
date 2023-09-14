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

@Stateless(name = "failModuleEJB")
public class failModuleBean {
    @EJB
    ConnectBean connectBean;
    public failModuleBean() {
    }

    public List<Map<String, String>> getMyBar3() {
        Connection connection = connectBean.getConnection();
        List<Map<String, String>> myBar3 = new ArrayList<>();

        try {
            String sql = "SELECT md.module_name, \n" +
                    "       fail_counts.fail\n" +
                    "FROM modules_dim md\n" +
                    "LEFT JOIN (\n" +
                    "    SELECT m.module_id, COUNT(*) AS fail\n" +
                    "    FROM mark m\n" +
                    "    WHERE m.status = 'Fail'\n" +
                    "    GROUP BY m.module_id\n" +
                    ") fail_counts ON md.module_id = fail_counts.module_id\n" +
                    "ORDER BY md.module_id ASC";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, String> myBarC = new HashMap<>();
                myBarC.put("moduleName", resultSet.getString("MODULE_NAME"));
                myBarC.put("fail", resultSet.getString("FAIL"));

                myBar3.add(myBarC);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myBar3;
    }
}
