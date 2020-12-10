package COM;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    private String name;

    private LocalDate foundingDate;

    public Company() {
    }

    public Company(String name, LocalDate foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDate foundingDate) {
        this.foundingDate = foundingDate;
    }

    public static Company getById(long id)
    {
        return Common.getById(Company.class,id);
    }

    public static Set<Company> getAll()
    {
        return Common.getAll(Company.class,"company" );
    }

    public static Company save(Company company)
    {
        return Common.save(company);
    }

    public static Company update(Company company)
    {
        return Common.update(company);
    }

    public static void delete(long id)
    {
        Common.delete(Company.class, id);
    }

}
