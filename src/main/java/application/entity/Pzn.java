package application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pzn")
public class Pzn {

    @Id
    @Column(name = "vkey")
    private String vkey;

    @Column(name = "pzn")
    private String pznPzn;

    @Column(name = "name")
    private String name;

}
