
package com.docsconsole.tutorials.entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = 88889999998L;
	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	
	@Column(name = "EMP_NAME")
	private String empName;
	
	@Column(name = "EMP_SAL")
	private Long empSal;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="EMPLOYEE_ORGANIZATION", joinColumns = @JoinColumn(name="EMP_ID", referencedColumnName = "EMP_ID"),
	inverseJoinColumns = @JoinColumn(name="ORG_ID", referencedColumnName = "ORG_ID"))
	private Organization organization;
	
	public Employee() {
	}

}
