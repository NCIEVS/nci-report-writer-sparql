package gov.nih.nci.evs.reportwriter.core.model.evs;

public class EvsProperty {
	String code;
	String label;
	String value;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString() {
		return "Code: " + this.code + "\n" +
	           " Label: " + this.label + "\n" +
			   " Value: " + this.value;
	}	
}
