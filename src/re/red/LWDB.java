package re.red;

import re.red.connectors.ConnectionHandler;
import re.red.datatypes.DataType;
import re.red.exceptions.TableNotFoundException;
import re.red.manager.table.Table;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LWDB {

    private final ConnectionHandler handler;

    public LWDB(ConnectionHandler handler){

        this.handler = handler;

    }

    public void createTable(String tableName, List<String> rowNames, List<DataType> types, List<Integer> sizes){

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < rowNames.size(); i++){

            builder.append(rowNames.get(i)).append(" ").append(types.get(i).getSqlType()).append("(").append(sizes.get(i))
                    .append("),");

        }

        int index = builder.lastIndexOf(",");
        builder.setCharAt(index, Character.MIN_VALUE);

        String query = builder.toString().trim();

        System.out.println(query);

        try{

            PreparedStatement preparedStatement = handler.getConnection().prepareStatement(
                    "CREATE TABLE " + tableName + " (" + query + ")"
            );

            preparedStatement.executeUpdate();

        }catch (SQLException exception){

            exception.printStackTrace();

        }

    }

    public Table getTable(String tableName) throws TableNotFoundException {

        return new Table(handler, tableName);

    }



}
