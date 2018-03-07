package com.gosling.core.ibatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

@MappedTypes(value = DataStatus.class)
public class DataStatusHandler implements TypeHandler<DataStatus> {

    @Override
    public void setParameter(PreparedStatement ps, int i, DataStatus parameter,
                             JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.toValue());
    }

    @Override
    public DataStatus getResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return DataStatus.fromValue(value);
    }

    @Override
    public DataStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        return DataStatus.fromValue(value);
    }

    @Override
    public DataStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        return DataStatus.fromValue(value);
    }

}
