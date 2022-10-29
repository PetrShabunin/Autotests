package work.home.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//{
//        "id": 1434654546,
//        "login": "test",
//        "loginType": "LOGIN",
//        "userInfo": [{
//        "name": "Тест",
//        "lastName": "Тестов",
//        "middleName": "Тестович",
//        }],
//        "isError": false
//        }

public class GetProfileJsonReader {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GetProfileBody {
        private static int id;
        public static int getId() {
            return id;
        }
        public void setId(int id) {
            GetProfileBody.id = id;
        }

        private static String login;
        public static String getLogin(){
            return login;
        }
        public void setLogin(String login) {
            GetProfileBody.login = login;
        }

        private static String loginType;
        public void setLoginType(String loginType) {
            GetProfileBody.loginType = loginType;
        }
        public static String getLoginType() {
            return loginType;
        }

        private List<UserInfo> userInfo;
        public void setUserInfo(List<UserInfo> userInfo) {
            this.userInfo = userInfo;
        }
        public List<UserInfo> getUserInfo(){
            return userInfo;
        }

        private boolean isError;
        public boolean isError(){
            return isError;
        }
        public void setError(boolean error) {
            isError = error;
        }
    }
    public static class UserInfo {
        private static String name;
        public static String getName() {
            return name;
        }
        public void setName(String name) {
            UserInfo.name = name;
        }

        private static String lastName;
        public static String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            UserInfo.lastName = lastName;
        }

        private static String middleName;
        public static String getMiddleName() {
            return middleName;
        }
        public void setMiddleName(String middleName) {
            UserInfo.middleName = middleName;
        }
    }
}
