package org.javautil.exceptionprocessing.dto;

// Generated Jun 7, 2009 8:20:16 PM by Hibernate Tools 3.2.2.GA

/**
 * UtTableRowMsgId generated by hbm2java
 */
public class UtTableRowMsgId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer utTableRuleNbr;
	private int utRuleGrpRunNbr;
	private Integer primaryKey;

	public UtTableRowMsgId() {
	}

	public UtTableRowMsgId(final Integer utTableRuleNbr,
			final int utRuleGrpRunNbr, final Integer primaryKey) {
		this.utTableRuleNbr = utTableRuleNbr;
		this.utRuleGrpRunNbr = utRuleGrpRunNbr;
		this.primaryKey = primaryKey;
	}

	public Integer getUtTableRuleNbr() {
		return this.utTableRuleNbr;
	}

	public void setUtTableRuleNbr(final Integer utTableRuleNbr) {
		this.utTableRuleNbr = utTableRuleNbr;
	}

	public int getUtRuleGrpRunNbr() {
		return this.utRuleGrpRunNbr;
	}

	public void setUtRuleGrpRunNbr(final int utRuleGrpRunNbr) {
		this.utRuleGrpRunNbr = utRuleGrpRunNbr;
	}

	public Integer getPrimaryKey() {
		return this.primaryKey;
	}

	public void setPrimaryKey(final Integer primaryKey) {
		this.primaryKey = primaryKey;
	}

}
