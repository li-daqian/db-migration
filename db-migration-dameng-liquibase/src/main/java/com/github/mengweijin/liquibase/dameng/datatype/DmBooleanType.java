package com.github.mengweijin.liquibase.dameng.datatype;

import liquibase.database.Database;
import liquibase.database.core.DmDatabase;
import liquibase.datatype.DataTypeInfo;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.LiquibaseDataType;
import liquibase.datatype.core.BooleanType;

@DataTypeInfo(
        name = "boolean",
        aliases = {"java.sql.Types.BOOLEAN", "java.lang.Boolean", "bit", "bool"},
        minParameters = 0,
        maxParameters = 0,
        priority = LiquibaseDataType.PRIORITY_DATABASE
)
public class DmBooleanType extends BooleanType {

    @Override
    public boolean supports(Database database) {
        return database instanceof DmDatabase;
    }

    @Override
    public DatabaseDataType toDatabaseDataType(Database database) {
        return new DatabaseDataType("NUMBER", 1);
    }
}
