LWDB
====
## LWDB aims to make using databases such as MySQL and SQLite as easy and SQL-less as possible. 
**LWDB** has all basic operations included such as: Creating, deleting and truncating a table. Updating, inserting into one and so on. Everything is based on lists!

Example
=======
```java
ConnectionHandler handler = new ConnectionHandler(Databases.MYSQL, "localhost", "3306", "database", "root", null);
LWDB lwdb = new LWDB(handler);
```

## And you can then start using the database! 

Creating a table
================
```java
List<String> columns = new ArrayList<>();
columns.add("name");
columns.add("id");

List<DataType> types = new ArrayList<>();
types.add(new Varchar());
types.add(new Integer());

List<Integer> sizes = new ArrayList<>();
sizes.add(16);
sizes.add(1);

String tableName = "account";

lwdb.createTable(tableName, columns, types, sizes);
```
This is what the table will look like:
![alt-text](https://i.imgur.com/sipAUgW.png "")
