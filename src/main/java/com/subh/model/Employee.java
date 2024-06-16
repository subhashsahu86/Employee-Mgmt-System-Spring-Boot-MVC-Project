package com.subh.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "emp")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id

	@SequenceGenerator(name = " gen1", sequenceName = "EMP_ID_SEQ", initialValue = 1, allocationSize = 1)

	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)

	private Integer empno;
	private String ename;
	private Double sal;
	private String job="CLERK";

}
