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
@Table(name = "uer")
public class Uer {

    @Id
    @Column(name = "vkey")
    private String vkey;

    @Column(name = "uer")
    private String uerUer;

    @Column(name = "uername")
    private String uerName;


}
