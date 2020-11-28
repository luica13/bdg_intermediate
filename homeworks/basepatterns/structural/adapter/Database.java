package patterns.basepatterns.structural.adapter;

public interface Database {
    void select();

    void update();

    void insert();

    void remove();
}
