package com.nagoor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Messages {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String msg;
	private String date;
	
public Messages() {
    super();
  }
public Messages(int id, String msg, String date) {
    super();
    this.id = id;
    this.msg = msg;
    this.date = date;
  }

public long getId() {
  return id;}
  public void setId(long id) {
  this.id = id;}
  public String getMsg() {
  return msg;}
  public void setMsg(String msg) {
  this.msg = msg;}
  public String getDate() {
  return date;}
  public void setDate(String date) {
  this.date = date;}
@Override public String toString(){return "Messages [id=" + id + ", msg=" + msg + ", date=" + date + "]";}
	
	
}
