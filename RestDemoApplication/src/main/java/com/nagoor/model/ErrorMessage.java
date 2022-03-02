package com.nagoor.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String emsg;
	private int ecode;
	private String descrption;
	
	
	
  public ErrorMessage() {
    super();
  }
  
  
public ErrorMessage(String emsg,int ecode,String descrption){super();this.emsg=emsg;this.ecode=ecode;this.descrption=descrption;}


public String getEmsg() {
  return emsg;}
  public void setEmsg(String emsg) {
  this.emsg = emsg;}
  public int getEcode() {
  return ecode;}
  public void setEcode(int ecode) {
  this.ecode = ecode;}
  public String getDescrption() {
  return descrption;}
  public void setDescrption(String descrption) {
  this.descrption = descrption;}
	
	
}
