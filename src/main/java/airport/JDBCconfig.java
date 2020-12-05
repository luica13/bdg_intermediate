package airport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCconfig {

        String url = "jdbc:postgresql://localhost:5432/airport";
        String userName = "postgres";
        String password = "postgres";
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
}
