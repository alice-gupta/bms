package com.bms.entities;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")

public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int isbn;
	private int price;
	private int quantity; 
	private String title;
	private String author;
	private String category;
	
	
	
	
}
