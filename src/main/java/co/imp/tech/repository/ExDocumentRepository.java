package co.imp.tech.repository;

import co.imp.tech.model.ExDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExDocumentRepository extends JpaRepository<ExDocument, Long> {
    @Query(value = "select d from ExDocument d left join d.exApprovalPics")
    Page<ExDocument> getMonitor(Pageable pageable);

    /**
     * If the pageable data is not compatible with the size determination,
     * it means that it needs to search for data that becomes recursive,
     * to overcome this it needs to create a different one but it needs
     * to create a sub query with the data wrapped in a new table like sub query
     * for complex cannot be handled in JPQL it needs nativeQuery because the reference is not Relation Object but the table itself
     *
     * @param pageable, determine page and size
     * @return Page<ExDocument>
     */
    @Query(value = "select distinct d.* from imp_document d left join imp_approval_pic a on d.id = a.document_id",
            countQuery = "select count(d.*) from imp_document d left join imp_approval_pic a on d.id = a.document_id",
            nativeQuery = true)
    Page<ExDocument> getMonitorWpic(Pageable pageable);
}
