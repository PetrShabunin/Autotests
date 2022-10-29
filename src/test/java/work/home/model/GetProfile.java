package work.home.model;
public class GetProfile {
    public int id;
    public String login;
    public String loginType;
    public UserInfo userInfo;
    public boolean isError;
    public static class UserInfo {
        public String name;
        public String lastName;
        public String middleName;
        public String birthday;
        public String email;
        public String phone;
    }

}

