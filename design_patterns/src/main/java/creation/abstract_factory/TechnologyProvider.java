package creation.abstract_factory;

public enum TechnologyProvider {
    APPLE("Apple"),
    SAMSUNG("Samsung");

    private String name;

    TechnologyProvider(String name) {
        this.name = name;
    }
}
