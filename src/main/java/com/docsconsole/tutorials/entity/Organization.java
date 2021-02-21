package com.docsconsole.tutorials.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ORGANIZATION")
public class Organization implements Serializable {

	private static final long serialVersionUID = 88889999999L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORG_ID")
	private Long orgId;

	@Column(name = "ORG_NAME")
	private String orgName;

	public Organization() {
	}
}
