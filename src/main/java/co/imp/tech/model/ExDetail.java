package co.imp.tech.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "imp_ex_detail")
public class ExDetail {
    @Id
    private String id;

    private String description;
    private String mention;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private ExUser idUser;
}
