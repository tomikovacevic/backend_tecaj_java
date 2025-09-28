import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class DrzavaRepository {
    public boolean add(String name) {
        if (name.isBlank()) {
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

            while (resultSet.next()) {
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

    public boolean dodavanjeDrzava(ArrayList<String> naziviDrzava) {
        if (naziviDrzava == null || naziviDrzava.isEmpty()) {
            return false;
        }

        DataSource datasource = createDataSource();

        StringBuilder query = new StringBuilder("insert into dbo.Drzava (Naziv) VALUES (?)");
        for (String naziv : naziviDrzava) {
            query.append("(?), ");
        }

        query.deleteCharAt(query.lastIndexOf(", "));

        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query.toString())) {

            for (int i = 1; i < naziviDrzava.size(); i++) {
                statement.setString(i, naziviDrzava.get(i));
            }
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == naziviDrzava.size()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int obrisDrzavePrekoIdja(int id) {
        if (id <= 4) {
            return 0;
        }

        DataSource dataSource = createDataSource();
        String query = "{CALL dbo.ObrisiDrzaveIznad (?)}";
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)) {
            cs.setInt("id", id);
            int rowsAffected = cs.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void izmijeniCijene() throws SQLException {
        String povecanje = "UPDATE dbo.Stavka SET CijenaPoKomadu = CijenaPoKomadu + 10 WHERE IDStavka = 8";
        String smanjenje = "UPDATE dbo.Stavka SET CijenaPoKomadu = CijenaPoKomadu - 10 WHERE IDStavka = 9";

        DataSource dataSource = createDataSource();

        try (Connection connection = dataSource.getConnection()) {
            try (Statement st1 = connection.createStatement();
                 Statement st2 = connection.createStatement()) {

                connection.setAutoCommit(false);
                st1.executeUpdate(povecanje);
                st2.executeUpdate(smanjenje);

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        }
    }

    public static void izmijeniUkupneCijene() throws SQLException {
        String queryUpdate8 = "UPDATE dbo.Stavka SET UkupnaCijena = CijenaPoKomadu * Kolicina WHERE IDStavka = 8";
        String queryUpdate9 = "UPDATE dbo.Stavka SET UkupnaCijena = CijenaPoKomadu * Kolicina WHERE IDStavka = 9";

        DataSource dataSource = createDataSource();

        try (Connection connection = dataSource.getConnection()) {
            try (Statement st1 = connection.createStatement();
                 Statement st2 = connection.createStatement()) {

                connection.setAutoCommit(false);
                st1.executeUpdate(queryUpdate8);
                st2.executeUpdate(queryUpdate9);

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
