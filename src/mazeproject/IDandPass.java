package mazeproject;

import java.util.HashMap;

public class IDandPass {

    private HashMap<String, String> logininfo = new HashMap<String, String>();

    IDandPass() {


        logininfo.put("Radu", "boss");
        logininfo.put("george", "enescu");
    }

    protected HashMap getlogininfo() {
        return logininfo;
    }


}

