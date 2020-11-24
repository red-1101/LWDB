package re.red.manager.table;

import re.red.connectors.ConnectionHandler;
import re.red.datatypes.DataType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Table implements TableGetters, TableUtil {

    private final ConnectionHandler handler;
    private final String tableName;

    private PreparedStatement preparedStatement;

    public Table(ConnectionHandler handler, String tableName){

        this.handler = handler;
        this.tableName = tableName;

    }

    @Override
    public String getStringValue(String selection, String whereCheck, String whereTo) {

        return (String) get(selection, whereCheck, whereTo);

    }

    @Override
    public int getIntValue(String selection, String whereCheck, String whereTo) {

        return (Integer) get(selection, whereCheck, whereTo);

    }

    @Override
    public double getDoubleValue(String selection, String whereCheck, String whereTo) {

        return (Double) get(selection, whereCheck, whereTo);

    }

    @Override
    public float getFloatValue(String selection, String whereCheck, String whereTo) {

        return (Float) get(selection, whereCheck, whereTo);

    }

    @Override
    public byte getByteValue(String selection, String whereCheck, String whereTo) {

        return (Byte) get(selection, whereCheck, whereTo);

    }

    @Override
    public short getShortValue(String selection, String whereCheck, String whereTo) {

        return (Short) get(selection, whereCheck, whereTo);

    }

    @Override
    public long getLongValue(String selection, String whereCheck, String whereTo) {

        return (Long) get(selection, whereCheck, whereTo);

    }

    @Override
    public Object get(String selection, String whereCheck, String whereTo) {

        try{

            preparedStatement = handler.getConnection().prepareStatement(
                    "SELECT " + selection + " FROM " + tableName + " WHERE " + whereCheck + "=?"
            );

            preparedStatement.setString(1, whereTo);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){

                preparedStatement.clearParameters();

                return resultSet.getObject(selection);

            }

            preparedStatement.clearParameters();

        } catch (SQLException exception) {

            exception.printStackTrace();

        }

        return null;

    }

    @Override
    public void insertInto(List<String> rowNames, List<Object> values) {

        StringBuilder builder = new StringBuilder();

        rowNames.forEach(row -> {

            builder.append(row).append(",");

        });

        StringBuilder builder1 = new StringBuilder();

        values.forEach(value -> {

            builder1.append(value).append(",");

        });

        String rows;
        String valuez;

        int index = builder.toString().lastIndexOf(",");
        int index1 = builder1.toString().lastIndexOf(",");

        builder.setCharAt(index, Character.MIN_VALUE);
        builder1.setCharAt(index1, Character.MIN_VALUE);

        rows = builder.toString();
        valuez = builder1.toString();

        int length = valuez.split(",").length;

        String marks;

        StringBuilder marksBuilder = new StringBuilder();

        for(int i = 0; i < length; i++){

            marksBuilder.append("?,");

        }

        int index2 = marksBuilder.toString().lastIndexOf(",");

        marksBuilder.setCharAt(index2, Character.MIN_VALUE);

        marks = marksBuilder.toString();

        try{

            preparedStatement = handler.getConnection().prepareStatement(
                    "INSERT INTO " + tableName + " (" + rows.trim() + ") VALUES (" + marks.trim() + ")"
            );

            for(int i = 0; i < length; i++){

                Object object = valuez.split(",")[i];
                
                preparedStatement.setObject(i + 1, object);

            }

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {

            exception.printStackTrace();

        }

    }

    @Override
    public void createTable(List<String> rowNames, List<DataType> types) {

        StringBuilder builder = new StringBuilder();

        types.forEach(dataType -> {

            rowNames.forEach(name -> {

                String sqlType = dataType.getSqlType();

                builder.append(name).append(" ").append(sqlType).append(" (100)");

            });

        });

        String rows = builder.toString();

        try{

            preparedStatement = handler.getConnection().prepareStatement(
                    "CREATE TABLE IF NOT EXISTS " + tableName + "("+ rows +")"
            );

            preparedStatement.executeUpdate();

            preparedStatement.clearParameters();

        } catch (SQLException exception) {

            exception.printStackTrace();

        }

    }

}
