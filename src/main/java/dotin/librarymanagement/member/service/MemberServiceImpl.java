package dotin.librarymanagement.member.service;

import dotin.librarymanagement.member.model.Member;
import dotin.librarymanagement.member.reporitory.MemberDao;
import dotin.librarymanagement.general.reporitory.GenericDao;
import dotin.librarymanagement.general.service.converter.UniqCardIdCreator;
import dotin.librarymanagement.general.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl extends GenericServiceImpl<Member, Long> implements MemberService {

    private MemberDao memberDao;
    private UniqCardIdCreator uniqCardIdCreator;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao, UniqCardIdCreator uniqCardIdCreator) {
        this.memberDao = memberDao;
        this.uniqCardIdCreator = uniqCardIdCreator;
    }

    @Override
    public GenericDao<Member, Long> getRelatedDao() {
        return this.memberDao;
    }

    @Override
    public List<Member> findAll(Member member) {
        return memberDao.findAll(member);
    }

    @Transactional
    @Override
    public boolean delete(Member member) {
        memberDao.delete(member);
        return true;
    }

    @Override
    public boolean save(Member member) {
        String cardId = uniqCardIdCreator.randomNumberProducer(member.getNationalCode());
        member.setRegistrationDate(System.currentTimeMillis());
        member.setCardId(cardId);
        super.save(member);
        return true;
    }

    @Override
    public boolean update(Member member) {

        List<Member> memberListObject = memberDao.findAll(member);

        Member memberObject = memberListObject.get(0);
        memberObject.setName(member.getName());
        memberObject.setFamily(member.getFamily());
        memberObject.setNationalCode(member.getNationalCode());
        memberObject.setAddress(member.getAddress());
        memberObject.setBirthDate(member.getBirthDate());

        super.update(memberObject);

        return true;
    }
}
