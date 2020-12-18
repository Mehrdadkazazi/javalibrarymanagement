package dotin.librarymanagement.member.reporitory;

import dotin.librarymanagement.member.model.Member;
import dotin.librarymanagement.general.reporitory.GenericDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member, Long> implements MemberDao {
    private Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);

    private EntityManager entityManager;

    @Autowired
    public MemberDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Member> findAll(Member member) {
        Query query = entityManager.createQuery("select entity from Member entity where entity.activation =: activation and (entity.name=:name or entity.family=:family or entity.cardId=:cardId or entity.nationalCode=:nationalCode)");
        query.setParameter("activation", 1);
        query.setParameter("name", member.getName());
        query.setParameter("family", member.getFamily());
        query.setParameter("cardId", member.getCardId());
        query.setParameter("nationalCode", member.getNationalCode());
        return query.getResultList();
    }

    @Override
    public boolean delete(Member member) {
        Query query = entityManager.createQuery("update Member entity set entity.activation=: activation where entity.id =: id");
        query.setParameter("activation", 0);
        query.setParameter("id", member.getId());
        query.executeUpdate();
        return true;
    }
}
