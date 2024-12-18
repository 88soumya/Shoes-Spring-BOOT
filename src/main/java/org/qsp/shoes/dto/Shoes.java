package org.qsp.shoes.dto;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Shoes {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String sBrand;
private String sColor;
private double price;
private int quantity;

}
