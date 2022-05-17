package com.fullstr.FullStore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "category") 
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Category implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "slug")
    private String slug;

    @Column(name = "image")
    private String image; 

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent; 
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonIgnore
    private List<Product> productCategory;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Category> children = new ArrayList<>(); 
    
    @Column(name = "active", columnDefinition = "boolean default true") 
    private boolean active;
  
    @CreationTimestamp 
    @Temporal(TemporalType.DATE) 
    @Column(name = "date_created")
    private Date dataCreated; 

    @UpdateTimestamp 
    @Temporal(TemporalType.DATE) 
    @Column(name = "last_update")
    private Date lastUpdate;
 
}
