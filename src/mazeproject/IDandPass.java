package mazeproject;

import java.sql.*;
import java.util.HashMap;

public class IDandPass {

    private HashMap<String, String> logininfo = new HashMap<String, String>();

    IDandPass() {

        String url = "jdbc:mysql://localhost:3306/utilizatori";
        String user = "root";
        String password = "123456";

        try {
            Connection myCon = DriverManager.getConnection(url, user, password);
            Statement statement = myCon.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tabel1");

            while (resultSet.next()) {
                logininfo.put(resultSet.getString("utilizator"), resultSet.getString("parola"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected HashMap getlogininfo() {
        return logininfo;
    }


}

