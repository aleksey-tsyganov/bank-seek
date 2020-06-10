package application.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reg")
public class Reg {

    @Id
    @Column(name = "vkey")
    private String vkey;

    @Column(name = "rgn")
    private String regRgn;

    @Column(name = "name")
    private String name;

}
