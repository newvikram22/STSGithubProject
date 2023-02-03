package com.example.github.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Airlinepojo implements Serializable{
	
	
	
	    private String referenceID;
	    private String businessName;
	   private List<ParamList> paramList ;
	    
	    

		public String getReferenceID() {
	        return referenceID;
	    }
	    public void setReferenceID(String referenceID) {
	        this.referenceID = referenceID;
	    }
	    public String getBusinessName() {
	        return businessName;
	    }
	    public void setBusinessName(String businessName) {
	        this.businessName = businessName;
	    }
	   public List<ParamList> getParamList() {
	        return paramList;
	    }
	    public void setParamList(List<ParamList> paramList) {
	        this.paramList = paramList;
	    }
}
