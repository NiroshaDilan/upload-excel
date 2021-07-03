package lk.icoder.uploadexcel.entity;

import javax.persistence.*;

/**
 * @Project spring-boot-upload-excel-files
 * @Author DILAN on 7/3/2021
 */
@Entity
@Table
public class Adjustment {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String curCaseStage;
   private String caseNumber;
   private String stageExpDate;
   private String pan;
   private String caseUpdated;
   private String currency;
   private String tranAmount;
   private String reasonCode;
   private String adjustmentAmount;
   private String issReconInstId;
   private String tranLocalDateTime;
   private String acqReconInstId;
   private String retrievalRef;
   private String procNtwk;
   private String actToIss;
   private String cardAcptTermId;
   private String cardAcptName;
   private String merchRptingLevel;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getCurCaseStage() {
      return curCaseStage;
   }

   public void setCurCaseStage(String curCaseStage) {
      this.curCaseStage = curCaseStage;
   }

   public String getCaseNumber() {
      return caseNumber;
   }

   public void setCaseNumber(String caseNumber) {
      this.caseNumber = caseNumber;
   }

   public String getStageExpDate() {
      return stageExpDate;
   }

   public void setStageExpDate(String stageExpDate) {
      this.stageExpDate = stageExpDate;
   }

   public String getPan() {
      return pan;
   }

   public void setPan(String pan) {
      this.pan = pan;
   }

   public String getCaseUpdated() {
      return caseUpdated;
   }

   public void setCaseUpdated(String caseUpdated) {
      this.caseUpdated = caseUpdated;
   }

   public String getCurrency() {
      return currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }

   public String getTranAmount() {
      return tranAmount;
   }

   public void setTranAmount(String tranAmount) {
      this.tranAmount = tranAmount;
   }

   public String getReasonCode() {
      return reasonCode;
   }

   public void setReasonCode(String reasonCode) {
      this.reasonCode = reasonCode;
   }

   public String getAdjustmentAmount() {
      return adjustmentAmount;
   }

   public void setAdjustmentAmount(String adjustmentAmount) {
      this.adjustmentAmount = adjustmentAmount;
   }

   public String getIssReconInstId() {
      return issReconInstId;
   }

   public void setIssReconInstId(String issReconInstId) {
      this.issReconInstId = issReconInstId;
   }

   public String getTranLocalDateTime() {
      return tranLocalDateTime;
   }

   public void setTranLocalDateTime(String tranLocalDateTime) {
      this.tranLocalDateTime = tranLocalDateTime;
   }

   public String getAcqReconInstId() {
      return acqReconInstId;
   }

   public void setAcqReconInstId(String acqReconInstId) {
      this.acqReconInstId = acqReconInstId;
   }

   public String getRetrievalRef() {
      return retrievalRef;
   }

   public void setRetrievalRef(String retrievalRef) {
      this.retrievalRef = retrievalRef;
   }

   public String getProcNtwk() {
      return procNtwk;
   }

   public void setProcNtwk(String procNtwk) {
      this.procNtwk = procNtwk;
   }

   public String getActToIss() {
      return actToIss;
   }

   public void setActToIss(String actToIss) {
      this.actToIss = actToIss;
   }

   public String getCardAcptTermId() {
      return cardAcptTermId;
   }

   public void setCardAcptTermId(String cardAcptTermId) {
      this.cardAcptTermId = cardAcptTermId;
   }

   public String getCardAcptName() {
      return cardAcptName;
   }

   public void setCardAcptName(String cardAcptName) {
      this.cardAcptName = cardAcptName;
   }

   public String getMerchRptingLevel() {
      return merchRptingLevel;
   }

   public void setMerchRptingLevel(String merchRptingLevel) {
      this.merchRptingLevel = merchRptingLevel;
   }
}
