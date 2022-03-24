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
            Member member1 = new Member();
            member1.setAge(10);
            member1.setUserName("김김");
            em.persist(member1);

            List<MemberDTO> results = em.createQuery("select new jpql.MemberDTO(m.userName, m.age) from Member m", MemberDTO.class)
                    .getResultList();
            MemberDTO memberDTO = results.get(0);
            System.out.println(memberDTO.getUserName());
            System.out.println(memberDTO.getAge());



            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        em.close();
        emf.close();

    }
}
