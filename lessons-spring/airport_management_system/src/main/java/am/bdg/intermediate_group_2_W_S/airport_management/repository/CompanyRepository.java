package am.bdg.intermediate_group_2_W_S.airport_management.repository;


import am.bdg.intermediate_group_2_W_S.airport_management.entity.Company;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
}
