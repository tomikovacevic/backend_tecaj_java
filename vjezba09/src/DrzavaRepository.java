import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DrzavaRepository {
    public boolean add(String name) {
        if(name.isBlank()) {
            return false;
        }

        DataSource datasource = createDataSource();

        String query = "insert into dbo.Drzava (Naziv) values ('" + name + "')";
        try (Connection connection = datasource.getConnection();
             Statement statement = connection.createStatement()) {

            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean izmjenaDrzave(int idDrzave, String nazivDrzave) {
        if (idDrzave <= 3) {
            return null;
        }

        DataSource datasource = createDataSource();
        String query = "update dbo.drzava set Naziv = '" + nazivDrzave + "' where IDDrzava = " + idDrzave;
        try (Connection connection = datasource.getConnection();
             Statement statement = connection.createStatement()) {

            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean brisanjeDrzave(int idDrzave) {
        if (idDrzave <= 3) {
            return null;
        }

        DataSource datasource = createDataSource();
        String query = "delete from dbo.Drzava where IDDrzava = " + idDrzave;
        try (Connection connection = datasource.getConnection();
             Statement statement = connection.createStatement()) {

            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Drzava> dohvatiDrzave() {
        ArrayList<Drzava> drzave = new ArrayList<>();

        DataSource datasource = createDataSource();
        String query = "select IDDrzava, Naziv from dbo.Drzava";
        try (Connection connection = datasource.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                int idDrzava = resultSet.getInt("IDDrzava");
                String naziv = resultSet.getString(1);
                Drzava drzava = new Drzava(idDrzava, naziv);
                drzave.add(drzava);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drzave;
    }

    private static DataSource createDataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("AdventureWorksOBP");
        dataSource.setUser("java");
        dataSource.setPassword("sql");
        dataSource.setEncrypt(false);
        return dataSource;
    }
}
