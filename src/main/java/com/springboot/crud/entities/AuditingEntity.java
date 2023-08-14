package com.springboot.crud.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AuditingEntity {
  @Column(name = "process_create_ts", nullable = false, updatable = false)
  private LocalDateTime processCreateTs;

  @Column(name = "process_create_by_user_id", nullable = false, updatable = false)
  private String processCreateByUserId;

  @Column(name = "process_create_by_program_id", nullable = false, updatable = false)
  private String processCreateByProgramId;

  @Column(name = "process_update_ts")
  private LocalDateTime processUpdateTs;

  @Column(name = "process_update_by_user_id")
  private String processUpdateByUserId;

  @Column(name = "process_update_by_program_id")
  private String processUpdateByProgramId;
}
