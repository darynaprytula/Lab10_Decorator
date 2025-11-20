package lab.store.decorators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lombok.SneakyThrows;

public class DBConnection {

    private static DBConnection instance;
    private final Connection connection;

    @SneakyThrows
    private DBConnection() {
        connection = DriverManager.getConnection("jdbc:sqlite:documents.db");
        initTable();
    }

    @SneakyThrows
    private void initTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS documents (
                    path TEXT PRIMARY KEY,
                    parsed TEXT
                )
                """;
        connection.createStatement().execute(sql);
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    @SneakyThrows
    public String getParsedByPath(String path) {
        String sql = "SELECT parsed FROM documents WHERE path = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, path);
        ResultSet rs = ps.executeQuery();

        String result = null;
        if (rs.next()) {
            result = rs.getString("parsed");
        }

        rs.close();
        ps.close();
        return result;
    }

    @SneakyThrows
    public void createDocument(String path, String parsed) {
        String sql = "INSERT OR REPLACE INTO documents(path, parsed) VALUES(?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, path);
        ps.setString(2, parsed);
        ps.executeUpdate();
        ps.close();
    }
}
