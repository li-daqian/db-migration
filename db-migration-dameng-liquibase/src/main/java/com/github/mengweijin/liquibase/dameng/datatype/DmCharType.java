package com.github.mengweijin.liquibase.dameng.datatype;

import liquibase.database.Database;
import liquibase.database.core.DmDatabase;
import liquibase.datatype.DataTypeInfo;
import liquibase.datatype.LiquibaseDataType;
import liquibase.datatype.core.CharType;
import liquibase.statement.DatabaseFunction;

import java.util.Locale;

@DataTypeInfo(
        name = "char",
        aliases = {"java.sql.Types.CHAR", "bpchar", "character"},
        minParameters = 0,
        maxParameters = 1,
        priority = LiquibaseDataType.PRIORITY_DATABASE
)
public class DmCharType extends CharType {

    @Override
    public boolean supports(Database database) {
        return database instanceof DmDatabase;
    }

    @Override
    public String objectToSql(Object value, Database database) {
        if (value == null || "null".equals(value.toString().toLowerCase(Locale.US))) {
            return null;
        }
        if (value instanceof DatabaseFunction) {
            return value.toString();
        }
        return "'" + database.escapeStringForDatabase(String.valueOf(value)) + "'";
    }
}
