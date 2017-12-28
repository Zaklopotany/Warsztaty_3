package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Excersise {
	private String title;
	private int id;
	private String description;

	// creator
	public Excersise() {

	}

	public Excersise(String title, String description) {
		super();
		setTitle(title);
		setDescription(description);

	}

	// getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	private Excersise setId(int id) {
		this.id = id;
		return this;
	}

	// communcation with DB
	// load All excersises
	public static Excersise[] loadAll(Connection con) throws SQLException {
		ArrayList<Excersise> excersise = new ArrayList<Excersise>();
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("Select * from excersise;");

		while (rs.next()) {
			Excersise tempExce = new Excersise();
			tempExce.setId(rs.getInt("id"));
			tempExce.setTitle(rs.getString("title"));
			tempExce.setDescription(rs.getString("description"));

			excersise.add(tempExce);

		}
		Excersise[] exceArr = new Excersise[excersise.size()];
		excersise.toArray(exceArr);

		return exceArr;

	}

	// load excersise by id

	public static Excersise loadById(Connection con, int id) throws SQLException {
		String sql = "Select * from excersise where id = ?;";
		PreparedStatement prepStat = con.prepareStatement(sql);
		prepStat.setInt(1, id);
		ResultSet rs = prepStat.executeQuery();

		Excersise tempExce = null;
		while (rs.next()) {
			tempExce = new Excersise();
			tempExce.setId(rs.getInt("id"));
			tempExce.setDescription(rs.getString("description"));
			tempExce.setTitle(rs.getString("title"));

		}

		return tempExce;

	}

	// save or update
	public void SaveToDB(Connection con) throws SQLException {

		if (this.getId() == 0) {
			String sql = "insert into excersise (title,description) values (?,?);";
			String[] genCol = { "id" };
			PreparedStatement prepStat = con.prepareStatement(sql, genCol);

			prepStat.setString(1, this.getTitle());
			prepStat.setString(2, this.getDescription());

			prepStat.executeUpdate();
			ResultSet rs = prepStat.getGeneratedKeys();

			if (rs.next()) {
				this.setId(rs.getInt(1));
			}
		} else {
			String sql = "Update excersise set title=?, description=? where id = ?";
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setString(1, this.getTitle());
			prepStat.setString(2, this.getDescription());
			prepStat.setInt(3, this.getId());

			prepStat.executeUpdate();

		}

	}

	public void delete(Connection con) throws SQLException {
		if (this.getId() != 0) {
			String sql = "delete from excersise where id = ?";
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, this.getId());

			prepStat.executeUpdate();
		}
	}

	// load all user solution by user id
	public static Solution[] loadAllByUserId(Connection con, String id) throws SQLException {
		String sql = "select s.excersise_id,s.created,s.updated,s.description from excersise e "
				+ "join solution s on e.id = s.excersise_id " + "where s.users_id = ? "
				+ "order by s.excersise_id ASC;";

		ArrayList<Solution> tempSolList = new ArrayList<Solution>();

		PreparedStatement prepStat = con.prepareStatement(sql);
		prepStat.setString(1, id);

		ResultSet rs = prepStat.executeQuery();
		while (rs.next()) {
			Solution tempSol = new Solution();
			tempSol.setCreated(rs.getString("created"));
			tempSol.setUpdated(rs.getString("updated"));
			tempSol.setDescription(rs.getString("description"));
			tempSol.setExcersiseId(rs.getInt("excersise_id"));

			tempSolList.add(tempSol);
		}

		Solution[] tempSolArr = new Solution[tempSolList.size()];
		tempSolList.toArray(tempSolArr);

		return tempSolArr;
	}

	public static Excersise[] loadUnsolved(Connection con, String id) throws SQLException {
		String sql = "SELECT * FROM excersise e " + "left join solution s " + "on (e.id = s.excersise_id) "
				+ "where s.users_id is null;";
		SELECT * FROM excersise e 
		left join (Select * from solution s where users_id = 4) s on s.excersise_id = e.id

		List<Excersise> listExceUnsolved = new ArrayList<Excersise>();

		PreparedStatement prepStat = con.prepareStatement(sql);
		prepStat.setString(1, id);
		try (ResultSet rs = prepStat.executeQuery()) {
			while (rs.next()) {
				Excersise tempExce = new Excersise();
				tempExce.setId(rs.getInt("id"));
				tempExce.setTitle("title");
				tempExce.setDescription("description");

				listExceUnsolved.add(tempExce);

			}
			Excersise[] tempExceArr = new Excersise[listExceUnsolved.size()];
			listExceUnsolved.toArray(tempExceArr);
			return tempExceArr;

		}

	}

	@Override
	public String toString() {
		return this.id + "   " + this.title + " -  " + this.description;
	}

}
