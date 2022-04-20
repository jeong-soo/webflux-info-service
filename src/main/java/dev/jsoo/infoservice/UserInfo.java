package dev.jsoo.infoservice;

public class UserInfo extends User{
    private String job = "job";
    public UserInfo(User user) {
        super.setName(user.getName());
        super.setMessage(user.getMessage());
    }

    public String getJob() {
        return job;
    }
}
