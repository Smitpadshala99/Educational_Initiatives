// Singleton Class
class ConfigurationManager {
    private static ConfigurationManager instance;
    private String config;

    private ConfigurationManager() {
        // private constructor to prevent instantiation
        config = "Default Configuration";
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}

// Main
public class SingletonPatternDemo {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        System.out.println("Config1: " + config1.getConfig());

        ConfigurationManager config2 = ConfigurationManager.getInstance();
        config2.setConfig("Custom Configuration");

        System.out.println("Config1: " + config1.getConfig());
        System.out.println("Config2: " + config2.getConfig());
    }
}
