package jpql;

public class MemberDTO {
    private String userName;
    private int age;
    //멤버DTO에는 TEAM변수왜 없어도되는거임? 왜?


    public MemberDTO(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
