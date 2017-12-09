package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
public class OfferDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatment = "select count(*) from grade";
		return jdbcTemplate.queryForObject(sqlStatment, Integer.class);
	}

	// query and return a single object
	public Offer getOffer(String name) {
		String sqlStatment = "select * from grade where name = ?";

		return jdbcTemplate.queryForObject(sqlStatment, new Object[] { name }, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				
				offer.setCode(rs.getString("code"));
				offer.setSubject(rs.getString("subject"));
				offer.setDivision(rs.getString("division"));
				offer.setGrades(rs.getInt("grades"));
				return offer;
			}
		});

	}

	// query and return a multiple object
	public List<Offer> getOffers() {
		String sqlStatment = "select * from grade ";

		return jdbcTemplate.query(sqlStatment, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				
				offer.setCode(rs.getString("code"));
				offer.setSubject(rs.getString("subject"));
				offer.setDivision(rs.getString("division"));
				offer.setGrades(rs.getInt("grades"));
				return offer;
			}
		});

	}
	
	public List<Offer> getOffers1(){
		String sqlStatment = "select year,semester,sum(grades) from grade where year<2018 group by year,semester";

		return jdbcTemplate.query(sqlStatment, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setGrades(rs.getInt("sum(grades)"));
				return offer;
			}
		});
	}

	public List<Offer> getOffers2(){
		String sqlStatment = "select year,semester,sum(grades) from grade where year<2018 group by year,semester";

		return jdbcTemplate.query(sqlStatment, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setGrades(rs.getInt("sum(grades)"));
				return offer;
			}
		});
	}
	public boolean insert(Offer offer) {
		int year = offer.getYear();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String subject = offer.getSubject();
		int grades = offer.getGrades();
		String division = offer.getDivision();
		String sqlStatment = "insert into grade (year,semester,code,subject,division,grades) values (?,?,?,?,?,?);";

		return (jdbcTemplate.update(sqlStatment, new Object[] {year,semester,code,subject,division,grades }) == 1);
	}

	

	public boolean delete(int id) {
		String sqlStatment = "delete from offers where id=?";
		return (jdbcTemplate.update(sqlStatment, new Object[] { id }) == 1);
	}

	public List<Offer> getOffers3() { // 이수 구분 별 학점 내역
		String sqlStatment = "select division,sum(grades) from grade where year<2018 group by division";
		List<Offer> offer =
		jdbcTemplate.query(sqlStatment, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setGrades(rs.getInt("sum(grades)"));
				offer.setDivision(rs.getString("division"));
				return offer;
			}
		});
		int sum =0;
		for(int i =0 ; i<offer.size(); i++) {
			sum += offer.get(i).getGrades();
		}
		offer.add(new Offer("총점",sum));
		return offer;
	}

	public List<Offer> getOffers4() {
		String sqlStatment = "select * from grade where year=2018";

		return jdbcTemplate.query(sqlStatment, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setSubject(rs.getString("subject"));
				offer.setDivision(rs.getString("division"));
				offer.setGrades(rs.getInt("grades"));
				return offer;
			}
		});
	}

	public List<Offer> getOffers5(int year1, int semester1) {
		String year = Integer.toString(year1);
		String semester = Integer.toString(semester1);
		String sqlStatment = "select code,subject,division,grades from grade where year="+year+" and semester="+semester;

		return jdbcTemplate.query(sqlStatment, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setCode(rs.getString("code"));
				offer.setSubject(rs.getString("subject"));
				offer.setDivision(rs.getString("division"));
				offer.setGrades(rs.getInt("grades"));
				return offer;
			}
		});
	}
}
