package co.imp.tech.repository;

import co.imp.tech.model.ExApprovalPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExApprovalPicRepository extends JpaRepository<ExApprovalPic, Long> {
}
