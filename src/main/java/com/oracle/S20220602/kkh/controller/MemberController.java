package com.oracle.S20220602.kkh.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.kkh.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "memlogin";
	}
	
	@PostMapping("/loginPro")
	public String loginPro(HttpServletRequest request, Member member, Model model) {
		System.out.println("MemberController loginPro start..");
		String input_id = member.getId();
		String input_pw = member.getPw();
		HttpSession session = request.getSession();
		session.setAttribute("id", input_id);
		System.out.println("input_id -> " + input_id);
		System.out.println("input_pw -> " + input_pw);
		member = ms.memberLogin(input_id);
		session.setAttribute("nickname", member.getNickname());
		model.addAttribute("input_id", input_id);
		model.addAttribute("input_pw", input_pw);
		model.addAttribute("member", member);
		return "memloginPro";
	}
	@GetMapping("/registerForm")
	public String registerForm(Member member, Model model) {
		System.out.println("MemberController registerForm start..");
		List<Common> selectLoc = ms.selectLocList();
		model.addAttribute("locList", selectLoc);
		return "memregisterForm";
	}
	@GetMapping("/register")
	public String register(Member member, Model model) {
		System.out.println("MemberController register start..");
		int result = ms.register(member);
		return "memlogin";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public String idcheck(Member member) {
		System.out.println("MemberController idCheck start..");
		String chk = "";
		int result = 0;
		if(member.getId().trim() == "") {
			chk = "none";
		}else {
			result = ms.idCheck(member);
			if(result == 1) {
				chk = "redundancy";
			}else if(result == 0) {
				chk = "noredundancy";
			}
		}
		return chk;
	}
	
	@GetMapping("/idFind")
	public String idFind(Model model) {

		return "memidFind";
	}

	@GetMapping("/idchk")
	@ResponseBody
	public Member idchk(Model model, Member member) {
		
		Member dbmember = ms.memberSelect(member);
		return dbmember;
	}

	@GetMapping("/pwForm")
	public String pwForm(Model model) {
		
		return "mempwForm";
	}
	@GetMapping("/pwFind")
	public String pwFind(Model model) {
		
		return "mempwFind";
	}
	
	@PostMapping("mailTransport")
	@ResponseBody
	public int mailTransport(HttpServletRequest request, Model model, Member member) {
		int result = 0;
		System.out.println("mailSending...");
		System.out.println("member email -> " + member.getEmail());
		String setfrom = "toltolyibh@gmail.com";
		String title = "인증번호입니다";                 // 제목
		String tempPassword = "";
		Member dbmember = null;
		try {
			// Mime 전자우편 Internet 표준 Format
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom);    // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(member.getEmail());       // 받는사람 이메일
			messageHelper.setSubject(title);   // 메일제목은 생략이 가능하다
			tempPassword = (int) (Math.random() * 999999) + 1 + "";
			
			messageHelper.setText("인증번호입니다 : " + tempPassword); // 메일 내용
			System.out.println("인증번호입니다 : " + tempPassword);
			
			dbmember = ms.EmailChk(member);
			if(dbmember.getChk() == 1) {
				dbmember.setTemppw(tempPassword);
				mailSender.send(message);
				ms.updateTempPw(dbmember);
				result = 1;
				return result;
			}else {
				return result;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	@PostMapping("/verifyChk")
	@ResponseBody
	public Member verifyChk(Model model, Member member) {
		System.out.println("MemberController verifyChk start..");
		System.out.println("member id ->  " + member.getId());
		System.out.println("member email ->  " + member.getEmail());
		System.out.println("member temp ->  " + member.getTemppw());
		Member dbmember = ms.memberSelectOne(member);
		System.out.println("dbmember id ->  " + dbmember.getId());
		System.out.println("dbmember email ->  " + dbmember.getEmail());
		System.out.println("dbmember temp ->  " + dbmember.getTemppw());
		
		return dbmember;
	}	
	
	
	//로그아웃
	@GetMapping("/logout")
	public String memlogout(HttpServletRequest request, Member member, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "memlogout";
	}
	
	//관리자
	@GetMapping("/adminlogin")
	public String adminlogin(Model model) {
		
		return "adminlogin";
	}
	
	@PostMapping("/adminloginPro")
	public String adminloginPro(HttpServletRequest request, Member member, Model model) {
		System.out.println("adminloginPro start..");
		String input_id = member.getId();
		String input_pw = member.getPw();
		HttpSession session = request.getSession();
		session.setAttribute("id", input_id);
		System.out.println("input_id -> " + input_id);
		System.out.println("input_pw -> " + input_pw);
		member = ms.memberLogin(input_id);
//		member = ms.adminChk(input_id);
		session.setAttribute("nickname", member.getNickname());
		model.addAttribute("input_id", input_id);
		model.addAttribute("input_pw", input_pw);
		model.addAttribute("member", member);
		return "adminloginPro";
	}
}
