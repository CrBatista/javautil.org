package org.javautil.sales.dto;
// Generated Sep 8, 2011 2:57:23 PM by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="PRODUCT"
    ,schema="PUBLIC"
    ,catalog="SALES"
)
public class Product  implements java.io.Serializable {


     private Integer productId;
     private String upc10;
     private String productStatus;
     private String descr;
     private String narrative;
     private Set<Sale> sales = new HashSet<Sale>(0);

    public Product() {
    }

	
    public Product(String upc10, String productStatus) {
        this.upc10 = upc10;
        this.productStatus = productStatus;
    }
    public Product(String upc10, String productStatus, String descr, String narrative, Set<Sale> sales) {
       this.upc10 = upc10;
       this.productStatus = productStatus;
       this.descr = descr;
       this.narrative = narrative;
       this.sales = sales;
    }
   
     @SequenceGenerator(name="generator", sequenceName="PRODUCT_NBR_SEQ")@Id @GeneratedValue(strategy=SEQUENCE, generator="generator")
    
    @Column(name="PRODUCT_ID", nullable=false, precision=9, scale=0)
    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    @Column(name="UPC10", unique=true, nullable=false, length=10)
    public String getUpc10() {
        return this.upc10;
    }
    
    public void setUpc10(String upc10) {
        this.upc10 = upc10;
    }
    
    @Column(name="PRODUCT_STATUS", nullable=false, length=1)
    public String getProductStatus() {
        return this.productStatus;
    }
    
    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
    
    @Column(name="DESCR", length=50)
    public String getDescr() {
        return this.descr;
    }
    
    public void setDescr(String descr) {
        this.descr = descr;
    }
    
    @Column(name="NARRATIVE")
    public String getNarrative() {
        return this.narrative;
    }
    
    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }
@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<Sale> getSales() {
        return this.sales;
    }
    
    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }




}

