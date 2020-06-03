package application.entity;

import application.utils.AppUtils;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


//TODO Добавить возможность выбор значений из выпадающего списка для полей PZN, TNP, UER,REG
//TODO Добавить текстовые пояснения для полей PZN, TNP, UER,REG
//TODO Доработать @UniqueKey валидатор для проверки уникальности поля NEWNUM

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bnkseek")
public class BankSeek {

    @Id
    @Column(name = "vkey")
    private String vkey;

    @Column(name = "`real`")
    private String real;

    @Column(name = "pzn")
    private String pzn;

    @NotNull
    @Column(name = "uer")
    private String uer;

    @NotNull
    @Column(name = "rgn")
    private String rgn;

    @Column(name = "ind")
    private String ind;

    @Column(name = "tnp")
    private String tnp;

    @Column(name = "nnp")
    private String nnp;

    @Column(name = "adr")
    private String adr;

    @Column(name = "rkc")
    private String rkc;

    @NotNull
    @Column(name = "namep")
    private String namep;

    @NotNull
    @Column(name = "namen")
    private String namen;

    @NotNull
    @Column(name = "newnum")
    private String newnum;

    @Column(name = "newks")
    private String newks;

    @Column(name = "permfo")
    private String permfo;

    @NotNull
    @Column(name = "srok")
    private String srok;

    @Column(name = "at1")
    private String at1;

    @Column(name = "at2")
    private String at2;

    @Column(name = "telef")
    private String telef;

    @Column(name = "regn")
    private String regn;

    @Column(name = "okpo")
    private String okpo;

    @Column(name = "cks")
    private String cks;

    @Column(name = "ksnp")
    private String ksnp;

    @Column(name = "vkeydel")
    private String vkeyDel;

    @NotNull
    @Column(name = "dt_izm")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dtIzm;

    @NotNull
    @Column(name = "date_in")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIn;

    @Column(name = "date_ch")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCh;

    @Column(name = "dt_izmr")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dtIzmr;


    public String getDate_ch() {
        return AppUtils.dateToString(this.dateCh);
    }

    public String getDate_in() {
        return AppUtils.dateToString(this.dateIn);
    }

    public String getDt_izm() {
        return AppUtils.dateToString(this.dtIzm);
    }

}


