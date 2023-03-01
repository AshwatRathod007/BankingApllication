package com.model;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
	 int accno;
	 String name;
     String pass;
	 String email;
	 int balance;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String pwd = "system";
	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection con = null;

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Model() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}

	public boolean login() {
		try {
			String sql = "select * from KOTBANK where accno =? and pass =? ";
		     pst = con.prepareStatement(sql);
			pst.setInt(1, accno);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if (rs.next()) {
			   accno = rs.getInt(1); 
			   pass = rs.getString(2);
				name = rs.getString(3);	
				email = rs.getString(4);
				balance = rs.getInt(5);
				return true;
			} else {
				return false;
			}
		} catch (Exception var2) {
			var2.printStackTrace();
			return false;
		}
	}

	public boolean register() {
		try {
			String sql = "insert into KOTBANK values(?,?,?,?,?)";
			this.pst = this.con.prepareStatement(sql);
			this.pst.setInt(1, this.accno);
			this.pst.setString(2, this.pass);
			this.pst.setString(3, this.name);
			this.pst.setString(4, this.email);
			this.pst.setInt(5, this.balance);
			int row = this.pst.executeUpdate();
			return row != 0;
		} catch (Exception var3) {
			var3.printStackTrace();
			return false;
		}
	}

	public boolean viewBalance() {
		try {
			String sql = "select balance from KOTBANK where accno=?";
			this.pst = this.con.prepareStatement(sql);
			this.pst.setInt(1, this.accno);
			this.rs = this.pst.executeQuery();
			if (this.rs.next()) {
				this.balance = this.rs.getInt("balance");
				return true;
			} else {
				return false;
			}
		} catch (Exception var2) {
			var2.printStackTrace();
			return false;
		}
	}

	public boolean changePwd(String np) {
		try {
			String sql = "update KOTBANK set pass = ? where accno=? and pass=?";
			this.pst = this.con.prepareStatement(sql);
			this.pst.setString(1, np);
			this.pst.setInt(2, this.accno);
			this.pst.setString(3, this.pass);
			int row = this.pst.executeUpdate();
			return row != 0;
		} catch (Exception var4) {
			var4.printStackTrace();
			return false;
		}
	}

	public boolean changeName() {
		try {
			String sql = "update KOTBANK set name = ? where accno=? and pass=?";
			this.pst = this.con.prepareStatement(sql);
			this.pst.setString(1, this.name);
			this.pst.setInt(2, this.accno);
			this.pst.setString(3, this.pass);
			int row = this.pst.executeUpdate();
			return row != 0;
		} catch (Exception var3) {
			var3.printStackTrace();
			return false;
		}
	}

	public boolean transfer(int amount, int taccno) {
		try {
			String sql1 = "update KOTBANK set balance = balance-? where accno=?";
			this.pst = this.con.prepareStatement(sql1);
			this.pst.setInt(1, amount);
			this.pst.setInt(2, this.accno);
			int row1 = this.pst.executeUpdate();
			String sql2 = "update KOTBANK set balance = balance+? where accno=?";
			this.pst = this.con.prepareStatement(sql2);
			this.pst.setInt(1, amount);
			this.pst.setInt(2, taccno);
			int row2 = this.pst.executeUpdate();
			return row1 != 0 && row2 != 0;
		} catch (Exception var7) {
			var7.printStackTrace();
			return false;
		}
	}

	public boolean forgotPassword(String np) {
		try {
			String sql = "update KOTBANK set pass = ? where accno=? and name=? and email=?";
			this.pst = this.con.prepareStatement(sql);
			this.pst.setString(1, np);
			this.pst.setInt(2, this.accno);
			this.pst.setString(3, this.name);
			this.pst.setString(4, this.email);
			int row = this.pst.executeUpdate();
			return row != 0;
		} catch (Exception var4) {
			var4.printStackTrace();
			return false;
		}
	}
}
