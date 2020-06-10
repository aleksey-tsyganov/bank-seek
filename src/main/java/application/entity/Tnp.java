package application.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tnp")
public class Tnp {

    @Id
    @Column(name = "vkey")
    private String vkey;

    @Column(name = "tnp")
    private String tnpTnp;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "shortname")
    private String shortName;
}
