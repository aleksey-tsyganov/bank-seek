package application.entity;

import application.utils.AppUtils;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

//TODO Доработать @UniqueKey валидатор.
//TODO Добавить текстовые пояснения для полей PZN, TNP, UER,REG

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
    @NotBlank
    @Column(name = "uer")
    private String uer;

    @NotNull
    @NotBlank
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
    @NotBlank
    @Column(name = "namep")
    private String namep;

    @NotNull
    @NotBlank
    @Column(name = "namen")
    private String namen;

    @NotNull
    @NotBlank
    @Column(name = "newnum")
    private String newnum;

    @Column(name = "newks")
    private String newks;

    @Column(name = "permfo")
    private String permfo;

    @NotNull
    @NotBlank
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


