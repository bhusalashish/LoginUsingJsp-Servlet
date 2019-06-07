package com.AshishNikki.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AshishNikki.model.User;
import com.AshishNikki.model.UserData;

public class Database {
	private Connection con=null;
	private ResultSet rs=null;
	private PreparedStatement pst=null;
	private boolean getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/watchvideo";
			con=DriverManager.getConnection(url,"ashish","password");
			System.out.println("Connection Established");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("could not get connection");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("could not get connection");
			e.printStackTrace();
			return false;
		}
	}
	private boolean doesUserExists(User user) {
		if(getConnection()) {
			try {
				String query="select password from usersinfo where email=?";
				pst=con.prepareStatement(query);
				pst.setString(1, user.getEmail());
				rs=pst.executeQuery();
				if(rs.next()) {
					String password=rs.getString("password");
					if(user.getPassword().equals(password))
						return true;
					else
						return false;
				}
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			finally {
				try {
					if(rs!=null) {
						rs.close();
						pst.close();
						con.close();
					}
					else if(pst!=null) {
						pst.close();
						con.close();
					}
					else if(con!=null) {
						con.close();
					}
				} catch (SQLException e) {
					System.out.println("Could not get close");
					e.printStackTrace();
				}
				
			}
		}
		else
			return false;
	}
	private boolean dublicate(UserData userdata) {
		if(getConnection()) {
			try {
				String query="select * from usersinfo where email=?";
				pst=con.prepareStatement(query);
				pst.setString(1, userdata.getEmail());
				rs=pst.executeQuery();
				if(rs.next())
					return true;
				else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return true;
			}
			finally {
				if(rs!=null) {
					try {
						rs.close();
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else if(pst!=null) {
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return true;
	}
	public boolean login(User user) {
		if(doesUserExists(user))
			return true;
		else
			return false;
	}
	public boolean signUp(UserData userdata) {
		if(!dublicate(userdata)) {
			String query="insert into usersinfo values(?,?,?,?,?)";
			try {
				pst=con.prepareStatement(query);
				pst.setString(1, userdata.getEmail());
				pst.setString(2, userdata.getPassword());
				pst.setString(3, userdata.getName());
				pst.setString(4, userdata.getPnumber());
				pst.setString(5, userdata.getGender());
				int n=pst.executeUpdate();
				if(n==1)
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

}
