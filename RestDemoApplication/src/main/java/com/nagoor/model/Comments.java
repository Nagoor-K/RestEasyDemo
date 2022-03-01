package com.nagoor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	private String comment;
	@ManyToOne
	private Messages msg;
	
	public Comments() {
		super();
	}
	
	
	
  public Comments(long cid, String comment, Messages msg) {
    super();
    this.cid = cid;
    this.comment = comment;
    this.msg = msg;
  }



public long getCid() {
  return cid;}
  public void setCid(long cid) {
  this.cid = cid;}
  public String getComment() {
  return comment;}
  public void setComment(String comment) {
  this.comment = comment;}
  public Messages getMsg() {
  return msg;}
  public void setMsg(Messages msg) {
  this.msg = msg;}



@Override public String toString(){return "Comments [cid=" + cid + ", comment=" + comment + ", msg=" + msg + "]";}
	
	
}
