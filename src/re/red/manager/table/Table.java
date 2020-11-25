package re.red.manager.table;

import re.red.connectors.ConnectionHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public final class Table implements TableGetters, TableUtil {

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

        try{

            preparedStatement = handler.getConnection().prepareStatement(
                    "INSERT INTO " + tableName + " (" + formatRows(rowNames) + ") VALUES (" + formatMarks(values) + ")"
            );

            for(int i = 0; i < values.size(); i++){

                Object object = values.get(i);

                preparedStatement.setObject(i + 1, object);

            }

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {

            exception.printStackTrace();

        }

    }

    @Override
    public void update(List<String> column, List<Object> values, String whereCheck, String whereTo) {

        System.out.println(updateFormat(column, values));

        try{

            preparedStatement = handler.getConnection().prepareStatement(
                    "UPDATE " + tableName + " SET " + updateFormat(column, values) + " WHERE " + whereCheck + "=?"
            );

            preparedStatement.setString(1, whereTo);

            preparedStatement.executeUpdate();

        }catch (SQLException exception){

            exception.printStackTrace();

        }

    }

    private String formatRows(List<String> raw){

        StringBuilder builder = new StringBuilder();

        raw.forEach(rawValue -> builder.append(rawValue).append(","));

        int index = builder.toString().lastIndexOf(",");

        builder.setCharAt(index, Character.MIN_VALUE);

        return builder.toString().trim();

    }

    private String formatMarks(List<Object> raw){

        StringBuilder builder = new StringBuilder();

        raw.forEach(value -> builder.append(value).append(","));

        int index = builder.toString().lastIndexOf(",");

        builder.setCharAt(index, Character.MIN_VALUE);

        String values = builder.toString();

        int length = values.split(",").length;

        StringBuilder marksBuilder = new StringBuilder();

        for(int i = 0; i < length; i++){

            marksBuilder.append("?,");

        }

        int index2 = marksBuilder.toString().lastIndexOf(",");

        marksBuilder.setCharAt(index2, Character.MIN_VALUE);

        String marks = marksBuilder.toString();

        return marks.trim();

    }

    private String updateFormat(List<String> list, List<Object> objectList){

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < list.size(); i++){

            if(objectList.get(i) instanceof String) {

                builder.append(list.get(i)).append("=").append("'").append(objectList.get(i)).append("'").append(",");

                continue;

            }

            builder.append(list.get(i)).append("=").append(objectList.get(i)).append(",");

        }

        int index = builder.toString().lastIndexOf(",");

        builder.setCharAt(index, Character.MIN_VALUE);

        String query = builder.toString();

        return query.trim();

    }


}
