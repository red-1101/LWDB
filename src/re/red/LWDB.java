package re.red;

import re.red.connectors.ConnectionHandler;
import re.red.manager.table.Table;

public class LWDB {

    private final ConnectionHandler handler;

    public LWDB(ConnectionHandler handler){

        this.handler = handler;

    }

    public Table getTable(String tableName){

        return new Table(handler, tableName);

    }



}
