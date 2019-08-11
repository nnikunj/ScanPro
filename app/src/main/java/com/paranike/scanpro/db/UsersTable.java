package com.paranike.scanpro.db;

public class UsersTable {
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_NAME = "userName";
    public static final String COLUMN_PASSWORD = "password";


    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_USERS + "(" +
                    COLUMN_USER_NAME + " TEXT PRIMARY KEY," +
                    COLUMN_PASSWORD + " TEXT" +

                    ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_USERS;
}
