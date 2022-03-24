package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //코드 추가
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team team = new Team();
            team.setName("team1");
            em.persist(team);

            Member member = new Member();
            member.setUserName("홍길동");
            member.setAge(12);
            member.addTeam(team);
            em.persist(member);

            Member member2 = new Member();
            member2.setUserName("김길동");
            member2.setAge(13);

            em.flush();
            em.clear();
            System.out.println("==============");
            String query = "select m from Member m inner join m.team t where m.age=12";
            List<Member> results = em.createQuery(query, Member.class)
                    .getResultList();
            for (Member member1 : results){
                System.out.println(member1.getUserName());
            }
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        em.close();
        emf.close();

    }
}
