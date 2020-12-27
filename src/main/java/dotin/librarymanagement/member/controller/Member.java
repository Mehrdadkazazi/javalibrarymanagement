package dotin.librarymanagement.member.controller;

import dotin.librarymanagement.general.controller.GenericController;
import dotin.librarymanagement.general.service.GenericService;
import dotin.librarymanagement.member.service.MemberService;
import dotin.librarymanagement.viewmodel.MemberViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class Member extends GenericController<MemberViewModel, dotin.librarymanagement.member.model.Member, Long> {

    private MemberService memberService;

    @Autowired
    public Member(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    protected GenericService<dotin.librarymanagement.member.model.Member, Long> getRelatedService() {
        return memberService;
    }

    @Override
    protected Class<MemberViewModel> getViewModelClass() {
        return MemberViewModel.class;
    }

    @Override
    protected Class<dotin.librarymanagement.member.model.Member> getModelClass() {
        return dotin.librarymanagement.member.model.Member.class;
    }
}
