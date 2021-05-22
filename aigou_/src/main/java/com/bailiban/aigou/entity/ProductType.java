package com.bailiban.aigou.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="s_Product_Type")
public class ProductType {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid",strategy="uuid")
	private String id;
	
	@Column(name="Product_Type_Name")
	private String ProductTypeName;
	
	@Column(name="Product_Type_Icon")
	private String ProductTypeIcon;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductTypeName() {
		return ProductTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		ProductTypeName = productTypeName;
	}

	public String getProductTypeIcon() {
		return ProductTypeIcon;
	}

	public void setProductTypeIcon(String productTypeIcon) {
		ProductTypeIcon = productTypeIcon;
	}

	
	
}
