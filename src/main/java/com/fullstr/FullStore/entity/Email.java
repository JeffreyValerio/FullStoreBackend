package com.fullstr.FullStore.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "email")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mail_from")
    private String from;

    @Column(name = "mail_to")
    private String to;

    @Column(name = "mail_subject")
    private String subject;

    @Column(name = "mail_text")
    private String text;
}
