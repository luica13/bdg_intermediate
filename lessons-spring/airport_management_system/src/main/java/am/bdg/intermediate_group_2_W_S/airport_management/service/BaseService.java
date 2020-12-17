package am.bdg.intermediate_group_2_W_S.airport_management.service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BaseService<T> {
    T get(Long id);

    Set<T> getAll();

    List<T> getCertainCrowd(int limit, int offset, String... sortKeys);

    T create(T entity);

    void loadEntitiesInfoFromFileAndCreateAll(String path);

    Optional<T> edit(T entity);

    void remove(T entity);

    void removeById(Long id);
}
