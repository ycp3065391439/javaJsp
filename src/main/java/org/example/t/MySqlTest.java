package org.example.t;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySqlTest {
    private String password;
    private String url;
    private String userName;


    public MySqlTest() {
    }

    public MySqlTest(String password, String url, String userName) {
        this.password = password;
        this.url = url;
        this.userName = userName;
    }
    public void findAll() throws Exception {
        Connection conn = DriverManager.getConnection(url, userName, password);
        String sql = "select * from stu;";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        while(resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        pstm.close();
        conn.close();
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
