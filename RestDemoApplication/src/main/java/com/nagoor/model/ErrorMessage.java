package com.nagoor.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private int errorcode;
	private String errormsg;
	private String expl;
	
	public ErrorMessage() {
		
	}
	
  public ErrorMessage(int errorcode, String errormsg, String expl) {
    super();
    this.errorcode = errorcode;
    this.errormsg = errormsg;
    this.expl = expl;
  }
public int getErrorcode() {
return errorcode;}
public void setErrorcode(int errorcode) {
this.errorcode = errorcode;}
public String getErrormsg() {
return errormsg;}
public void setErrormsg(String errormsg) {
this.errormsg = errormsg;}
public String getExpl() {
return expl;}
public void setExpl(String expl) {
this.expl = expl;}
  
  
	
	
}

