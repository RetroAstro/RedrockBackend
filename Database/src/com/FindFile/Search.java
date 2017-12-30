package com.FindFile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.Servlet.FindRows;
public class Search {

    public static List searchfile(String filename) {
        PreparedStatement pstmt = FindRows.getPstmt();
        ResultSet resultSet;
        List<Map<String,String>> info = new ArrayList<>();

        try{
            pstmt.setString(1,( "%" + filename + "%" ));
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("文件名", resultSet.getString("name"));
                map.put("绝对路径", resultSet.getString("path"));
                map.put("最后修改时间", resultSet.getString("lastime"));
                info.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }

}
