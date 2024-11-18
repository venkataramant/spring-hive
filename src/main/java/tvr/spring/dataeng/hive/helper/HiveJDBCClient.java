package tvr.spring.dataeng.hive.helper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.DriverManager;

@Component
public class HiveJDBCClient {

    public String runQuery() throws Exception {
        System.out.println("testing");
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        java.sql.Connection connection = DriverManager.getConnection("jdbc:hive2://localhost:10000/mydbnov16", "admin", "admiN123Pass");
        var stmt = connection.createStatement();
        var rs = stmt.executeQuery("SELECT * FROM mydbnov16.tab1");
        if (rs != null) {
            while (rs.next()) {
                var msg=new StringBuilder().append("name::")
                                    .append(rs.getString(1))
                                    .append(",age::").append( rs.getInt(2)).toString();
                System.out.println(msg);
                return msg;
            }
        }
        return "No Data";
    }
}
