package airport_management_system.util;

import java.io.IOException;
import java.util.Properties;

public final class DBInfoLoader {
    private final Properties dbProps = new Properties();

    private DBInfoLoader() {
        try {
            dbProps.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getDBProps() {
        return DBInfoLoaderCreator.INFO_LOADER.dbProps;
    }

    private static class DBInfoLoaderCreator {
        private static final DBInfoLoader INFO_LOADER = new DBInfoLoader();
    }
}
