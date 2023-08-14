package com.springboot.crud.entities;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rework_claim_detail")
public class ReworkClaimDetail extends AuditingEntity {

  @Id
  @NotNull
  @Column(name = "rework_claim_detail_id")
  private Long reworkClaimDetailId;

  @NotNull
  @Column(name = "rework_batch_event_id")
  private Long reworkBatchEventId;

  @NotNull
  @Column(name = "claim_id")
  private String claimId;

  @NotNull
  @Column(name = "member_a_to_b_type_cd")
  private Character memberAToBTypeCd;

  @Column(name = "financial_cycle_id")
  private Long financialCycleId;

  @Column(name = "adjustment_reason_id")
  private Long adjustmentReasonId;

  @NotNull
  @Column(name = "financial_cycle_cd")
  private String financialCycleCd;

  @NotNull
  @Column(name = "client_id")
  private Long clientId;

  @NotNull
  @Column(name = "group_id")
  private Long groupId;

  @NotNull
  @Column(name = "member_id")
  private String memberId;

  @Column(name = "prerap_claim_status_cd")
  private String prerapClaimStatusCd;

  @NotNull
  @Column(name = "included_in_financials_cd")
  private Character includedInFinancialsCd;

  @NotNull
  @Column(name = "adjustment_status_cd")
  private String adjustmentStatusCd;

  @NotNull
  @Column(name = "added_dt")
  private LocalDate addedDt;

  @NotNull
  @Column(name = "member_fix_applied_cd")
  private Character memberFixAppliedCd;

  @NotNull
  @Column(name = "claim_adjustment_source_cd")
  private String claimAdjustmentSourceCd;

  @NotNull
  @Column(name = "pharmacy_fix_applied_cd")
  private Character pharmacyFixAppliedCd;

  @NotNull
  @Column(name = "originating_claim_id")
  private String originatingClaimId;

  @NotNull
  @Column(name = "original_customer_id")
  private Long originalCustomerId;

  @NotNull
  @Column(name = "original_client_id")
  private Long originalClientId;

  @NotNull
  @Column(name = "original_group_id")
  private Long originalGroupId;

  @NotNull
  @Column(name = "original_member_id")
  private String originalMemberId;

  @Column(name = "begin_adjustment_dt")
  private LocalDate beginAdjustmentDt;

  @Column(name = "end_adjustment_dt")
  private LocalDate endAdjustmentDt;

  @NotNull
  @Column(name = "unarchive_status_cd")
  private Character unarchiveStatusCd;

  @NotNull
  @Column(name = "financials_status_cd")
  private Character financialsStatusCd;

  @NotNull
  @Column(name = "on_pct_cd")
  private Character onPctCd;

  @NotNull
  @Column(name = "queue_number_id")
  // TODO Need to check on type.
  //
  // has type as Integer in all other places
  // com.rxtransaction.claims.service.rework.request.ReworkRequest.reworkBatchEventJobQueueNumberId
  // com.rxtransaction.claims.service.rework.entities.schema_rework.HReworkBatchProcessControl.queueNumberId
  // com.rxtransaction.claims.service.rework.entities.schema_rework.ReworkBatchProcessControl.queueNumberId
  private Long queueNumberId;

  @NotNull
  @Column(name = "member_a_to_b_ind")
  // TODO Need to check on type of this field. Matched (Length = 1, Not Boolean type, String type
  // only) but field name not ended with Cd
  private String memberAToBInd;

  @Column(name = "member_a_to_b_birth_dt")
  private LocalDate memberAToBBirthDt;

  @NotNull
  @Column(name = "member_a_to_b_first_nm")
  private String memberAToBFirstNm;

  @NotNull
  @Column(name = "member_a_to_b_middle_initial_nm")
  // TODO Need to check on type of this field. Matched (Length = 1, Not Boolean type, String type
  // only) but field name not ended with Cd
  private String memberAToBMiddleInitialNm;

  @NotNull
  @Column(name = "member_a_to_b_last_nm")
  private String memberAToBLastNm;

  @NotNull
  @Column(name = "associated_nx_cd")
  private Character associatedNxCd;

  @Column(name = "associated_claim_id")
  private String associatedClaimId;

  @Column(name = "processed_cd")
  private Character processedCd;

  @Column(name = "external_group_id")
  private String externalGroupId;

  @Column(name = "cics_override_applied_cd")
  private Character cicsOverrideAppliedCd;

  @Column(name = "alternate_member_id_fix_applied_cd")
  private Character alternateMemberIdFixAppliedCd;

  @Column(name = "mbr_dollar_deduct_prcsd_cd")
  private Character mbrDollarDeductPrcsdCd;

  @Column(name = "adjustment_dt")
  private String adjustmentDt;

  @Column(name = "noncritical_time_frame_process_cd")
  private Character noncriticalTimeFrameProcessCd;

  @Column(name = "filled_dt")
  private LocalDate filledDt;

  @Column(name = "trigger_rework_financial_cycle_cd")
  private Character triggerReworkFinancialCycleCd;
}
