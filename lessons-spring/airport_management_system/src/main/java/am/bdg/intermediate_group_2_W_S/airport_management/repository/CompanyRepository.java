package am.bdg.intermediate_group_2_W_S.airport_management.repository;


import am.bdg.intermediate_group_2_W_S.airport_management.model.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
}
