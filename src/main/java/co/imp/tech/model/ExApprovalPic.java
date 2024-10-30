package co.imp.tech.model;

import co.imp.tech.model.base.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "imp_approval_pic")
public class ExApprovalPic extends BaseModel {
    private String approvedBy;

    private LocalDateTime approvalDate;
    private String approvalPicUrl;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private ExDocument document;
}
