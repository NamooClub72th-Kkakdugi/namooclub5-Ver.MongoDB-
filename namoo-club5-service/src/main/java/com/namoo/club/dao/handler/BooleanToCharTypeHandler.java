package com.namoo.club.dao.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

// Java type <==> JDBC type
//  true  <=> Y
//  false <=> N
public class BooleanToCharTypeHandler implements TypeHandler<Boolean>{

	@Override
	public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
		// 
		if ("Y".equals(rs.getString(columnName))) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
		// 
		if ("Y".equals(rs.getString(columnIndex))) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// 
		return null;
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
		// 
		ps.setString(i, parameter ? "Y" : "N");
	}

}
