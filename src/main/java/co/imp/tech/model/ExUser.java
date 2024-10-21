package co.imp.tech.model;

import co.imp.tech.model.base.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "imp_ex_user")
public class ExUser extends BaseModel {
    private String name;
    private String email;

    @OneToMany(mappedBy = "idUser")
    private List<ExDetail> exDetail;
}
