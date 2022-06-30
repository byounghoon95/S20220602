package com.oracle.S20220602.ksh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Member;


@Repository
public class A_MemberListRepositoryImpl implements A_MemberListRepository {

	@Autowired
	private SqlSession session; // 마이바티스

	@Override
	public int total() {
		int tot = 0;
		System.out.println("A_MemberListRepositoryImpl Start total...");
		try {
			// Naming Rule  --->    Map ID
			tot = session.selectOne("kshMemberTotal"); // 한줄로 왔을때 :selectOne ,여러줄로오면:selectList
			System.out.println("A_MemberListRepositoryImpl total tot->" + tot);
		} catch (Exception e) {
			System.out.println("A_MemberListRepositoryImpl toal Exception->" + e.getMessage());
		}

		return tot;
	}

	@Override
	public List<Member> listMember(Member member) {
		List<Member> memberList = null;
		System.out.println("A_MemberListRepositoryImpl listMember Start ...");
		try {
			// Naming Rule                    Map ID           Parameter(파라메터에 여러개를 집어 넣을 떈 dto)
			memberList = session.selectList("kshMemberListAll3", member);
			System.out.println("A_MemberListRepositoryImpl.size() -->"+memberList.size());
		} catch (Exception e) {
			System.out.println("A_MemberListRepositoryImpl listMember Exception->" + e.getMessage());
		}
		return memberList;
	}

	@Override
	public Member detail(String id) {
		Member member = new Member();
		try {
			// 프라이머리키인 id로 가져오기 떄문에 selectOne                  
			member = session.selectOne("kshMemberDetail", id);
			 System.out.println("A_MemberListRepositoryImpl getName -->"+member.getName());
		} catch (Exception e) {
			System.out.println("A_MemberListRepositoryImpl detail Exception->" + e.getMessage());
		}
		
		return member;
	}

	@Override 
	public int update(Member member) {
	  System.out.println("A_MemberListRepositoryImpl update start.."); 
	  int kkk = 0;
	  try {
		  kkk = session.update("kshMemberUpdate",member); 
	  } catch (Exception e) {
	  System.out.println("A_MemberListRepositoryImpl update Exception->"+e.getMessage()); 
	  } 
	  
	  return kkk;
	
	}

	@Override
	public List<Member> A_Mkeyword(Member member) {
		List<Member> A_Mkeyword = null;
		System.out.println("A_MemberListRepositoryImpl A_Mkeyword Start ...");
		System.out.println("A_MemberListRepositoryImpl A_Mkeyword member.getSearch()-->"+member.getSearch());
		System.out.println("A_MemberListRepositoryImpl A_Mkeyword member.getKeyword()-->"+member.getKeyword());
		if(member.getKeyword()==null) member.setKeyword("%");
		try {
			// Naming Rule                    Map ID           Parameter(파라메터에 여러개를 집어 넣을 떈 dto)
			A_Mkeyword = session.selectList("kshMemberKeyword", member);
		
		} catch (Exception e) {
			System.out.println("A_MemberListRepositoryImpl A_Mkeyword Exception->" + e.getMessage());
		}
		return A_Mkeyword;
	}

	@Override
	public int totalKeyword(Member member) {
		int tot = 0;
		System.out.println("A_MemberListRepositoryImpl totalKeyword Start ...");
		try {
			// Naming Rule  --->         Map ID            ,parameter
			tot = session.selectOne("kshMemberTotalKeyword",member); 
			System.out.println("A_MemberListRepositoryImpl totalKeyword tot->" + tot);
		} catch (Exception e) {
			System.out.println("A_MemberListRepositoryImpl totalKeyword Exception->" + e.getMessage());
		}

		return tot;
	}

	@Override
	public int delete(Member member) {
		System.out.println("A_MemberListRepositoryImpl delete Start");
		int result = 0;
		try {
			result = session.update("kshMemberDelete", member);
		}catch (Exception e) {
			System.out.println("A_MemberListRepositoryImpl delete Exception -> " + e.getMessage());
		}
		return result;
	}

	
	 
	  @Override
	   public List<Common> StatusList(Common common) {
	      System.out.println("A_MemberListRepository reportCategorySelect Start....");
	      List<Common> memberStatusList = null;
	      try {
	    	  memberStatusList = session.selectList("kshMemberStatusList");
	         System.out.println("A_MemberListRepository StatusList  memberStatusList.size()->"+memberStatusList.size());
	         
	           for(Common memberStatus : memberStatusList) 
	           { System.out.println("A_MemberListRepository StatusList   memberStatus.getMcd()->" + memberStatus.getMcd() );
	             System.out.println("A_MemberListRepository StatusList memberStatus.getContent())->" + memberStatus.getContent() );
	           }
	      }catch(Exception e){
	         System.out.println("A_MemberListRepository StatusList Exception->"+e.getMessage());
	      }
	      return memberStatusList;
	   }
}
