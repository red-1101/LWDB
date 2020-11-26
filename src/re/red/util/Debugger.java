package re.red.util;

public class Debugger {

    private final boolean enabled;

    public Debugger(boolean enabled){

        this.enabled = enabled;

    }

    public void debug(String message){

        if(!enabled) return;

        System.out.println(message);

    }

}
