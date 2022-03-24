package jpql;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private int age;

    private Team getTeam() {
        return team;
    }

    private void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public void addTeam(Team team){
        setTeam(team);
        team.getMembers().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
