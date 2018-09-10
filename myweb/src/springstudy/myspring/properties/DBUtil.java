package springstudy.myspring.properties;

/**
 * Created by 16643 on 2018/7/22.
 */
public class DBUtil {
    private String drivername;
    private String url;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "DBUtil{" +
                "drivername='" + drivername + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
