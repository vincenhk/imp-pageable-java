package co.imp.tech.repository;

import co.imp.tech.model.ExUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExUserRepository extends JpaRepository<ExUser, Long> {

    Page<ExUser> findAllBy(Pageable pageable);

    @Query("SELECT h FROM ExUser h")
    List<ExUser> findAllCustom(Pageable pageable);

    @Query("select h from ExUser h join h.exDetail")
    List<ExUser> findDetail(Pageable pageable);
}
