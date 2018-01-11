package linuxshell;

import domain.model.BaseModel;

public class ServerDetails extends BaseModel {
    private String Ip;
    private String UserName;
    private String PassWd;
    private String ScriptPath;
    private String ParameterOne;
    private String ParameterTwo;

    public String getParameterOne() {
        return ParameterOne;
    }

    public void setParameterOne(String parameterOne) {
        ParameterOne = parameterOne;
    }

    public String getParameterTwo() {
        return ParameterTwo;
    }

    public void setParameterTwo(String parameterTwo) {
        ParameterTwo = parameterTwo;
    }



    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWd() {
        return PassWd;
    }

    public void setPassWd(String passWd) {
        PassWd = passWd;
    }

    public String getScriptPath() {
        return ScriptPath;
    }

    public void setScriptPath(String scriptPath) {
        ScriptPath = scriptPath;
    }



}
