package lesson11.InterfaceExample;

public class PostgreSQLDbProvider implements DbProvider {
    @Override
    public void connectToDb() {
        //some logic for Postgres
    }

    @Override
    public void disconnectFromDb() {
        //some logic for Postgres
    }

    @Override
    public void encryptData() {
        //some logic for Postgres
    }
}
