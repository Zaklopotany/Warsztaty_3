package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserGroup {
	private int id;
	private String name;

	public UserGroup() {
		super();
	}

	public UserGroup(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public UserGroup(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public UserGroup setName(String name) {
		this.name = name;
		return this;
	}

	public int getId() {
		return id;
	}

	private UserGroup setId(int id) {
		this.id = id;
		return this;
	}

	// communcation with DB
	// load All excersises
	public static UserGroup[] loadAll() {
		ArrayList<UserGroup> userGroup = new ArrayList<UserGroup>();
		try (Connection con = DbUtil.getConn()) {
			Statement stat = con.createStatement();
			try (ResultSet rs = stat.executeQuery("Select * from user_group;");) {
				while (rs.next()) {
					UserGroup tempUsGr = new UserGroup();
					tempUsGr.setId(rs.getInt("id"));
					tempUsGr.setName(rs.getString("name"));

					userGroup.add(tempUsGr);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		UserGroup[] userGroupArr = new UserGroup[userGroup.size()];
		userGroup.toArray(userGroupArr);

		return userGroupArr;
	}

	// load excersise by id

	public static UserGroup loadById(int id) {
		String sql = "Select * from user_group where id = ?;";
		UserGroup tempUserGroup = null;
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, id);
			try (ResultSet rs = prepStat.executeQuery();) {
				while (rs.next()) {
					tempUserGroup = new UserGroup();
					tempUserGroup.setId(rs.getInt("id"));
					tempUserGroup.setName(rs.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tempUserGroup;
	}

	// save or update
	public void SaveToDB() {
		try (Connection con = DbUtil.getConn()) {
			if (this.getId() == 0) {
				String sql = "insert into user_group (name) values (?);";
				String[] genCol = { "id" };
				PreparedStatement prepStat = con.prepareStatement(sql, genCol);
				prepStat.setString(1, this.getName());
				prepStat.executeUpdate();

				try (ResultSet rs = prepStat.getGeneratedKeys();) {
					if (rs.next()) {
						this.setId(rs.getInt(1));
					}
				}
			} else {
				String sql = "Update user_group set name=? where id = ?";
				PreparedStatement prepStat = con.prepareStatement(sql);
				
				prepStat.setString(1, this.getName());
				prepStat.setInt(2, this.getId());
				prepStat.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Connection con) throws SQLException {
		if (this.getId() != 0) {
			String sql = "delete from user_group where id = ?";
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, this.getId());

			prepStat.executeUpdate();
		}
	}

	public String toString() {
		return this.getId() + " " + this.getName();
	}

}
