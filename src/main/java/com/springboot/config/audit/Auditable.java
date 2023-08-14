package com.springboot.config.audit;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/*
 * Below annotation tells us, 
 * This class is not an entity to create separate table in DB. 
 * This class only acts as a super class for other entities 
 * 		and these fields will be added in that entity for auditing purpose.
 */
@MappedSuperclass	

/*
 * It is used to configure JPA entity listener (i.e., AuditingEntityListener) 
 * 	to capture auditing info or operating the records while save/update/delete.
 */
@EntityListeners(AuditingEntityListener.class)
public class Auditable {
	
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private LocalDateTime createdOn;
	
	@LastModifiedBy
	private String lastModifiedBy;
	
	@LastModifiedDate
	private LocalDateTime lastModifiedOn;
	

}
