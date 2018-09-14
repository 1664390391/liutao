package springstudy.myspring4.webdemo.bean;

import java.io.Serializable;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/14
 */
public class User implements Serializable {
    private String userId;
    private String userName;
    private String userPsw;
    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPsw='" + userPsw + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
