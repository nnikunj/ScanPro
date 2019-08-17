package com.paranike.scanpro.db;

public class UsersTable {
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_NAME = "userName";
    public static final String COLUMN_USER_SALT = "salt";
    public static final String COLUMN_PASSWORD_SHADOW = "password_shadow";


    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_USERS + "(" +
                    COLUMN_USER_NAME + " TEXT PRIMARY KEY," +
                    COLUMN_USER_SALT + " TEXT, " +
                    COLUMN_PASSWORD_SHADOW + " TEXT " +

                    ");";

    public static final String[] CREATE_INDICES = {
            "CREATE INDEX IF NOT EXISTS "+TABLE_USERS+"_"+COLUMN_USER_NAME+"_idx on "+ TABLE_USERS+"("+COLUMN_USER_NAME+");"

    };

    public static final String[] DROP_INDICES = {
            "DROP INDEX IF EXISTS "+TABLE_USERS+"_"+COLUMN_USER_NAME+"_idx ;"

    };

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_USERS;
}
