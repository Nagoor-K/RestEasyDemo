package com.nagoor.app.exceptions;

public class DataNotFoundEception extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = -8321531705446099764L;
	
  public DataNotFoundEception(String message) {
	  super(message);
  }
}
