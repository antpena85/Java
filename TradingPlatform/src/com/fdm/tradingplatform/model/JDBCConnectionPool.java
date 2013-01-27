package com.fdm.tradingplatform.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionPool extends AbstractObjectPool<Connection> implements iConnectionPool{
  private String address, username, password;

  public JDBCConnectionPool(String address, String username, String password,long experationTime) {
    super(experationTime);

    this.address = address;
    this.username = username;
    this.password = password;
  }

  @Override
  protected Connection create() {
    try {
      return (DriverManager.getConnection(address, username, password));
    } catch (SQLException e) {
      e.printStackTrace();
      return (null);
    }
  }

  @Override
  public void expire(Connection connection) {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean validate(Connection connection) {
    try {
      return !connection.isClosed();
    } catch (SQLException e) {
      e.printStackTrace();
      return (false);
    }
  }

  public void cleanUp(){
	  
	  try{
		  for(Connection connection : locked.keySet()){
			  connection.close();
		  }
		  
		  for(Connection connection : unlocked.keySet()){
			  connection.close();
		  }
	  }catch(SQLException e){
		  throw new RuntimeException("There has been an unexpected error. Please Contact the Systems Administrator.");
	  }
	  
  }
  
@Override
public Object getConnection(String key) {
	
	return this;
}
}
