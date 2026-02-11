package com.example.guestbook;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookRepository guestbookRepository;

    // 메인 화면: 글 목록 보여주기
    @GetMapping("/")
    public String list(Model model) {
        // DB에서 모든 글을 가져와서 'list'라는 이름으로 화면에 전달
        model.addAttribute("list", guestbookRepository.findAllByOrderByGnoDesc());
        return "list"; // list.html 파일을 보여줘라!
    }

    // 글 쓰기 화면 띄우기
    @GetMapping("/register")
    public String register() {
        return "register"; // register.html 파일을 보여줘라!
    }

    // 실제로 글 저장하기 버튼 눌렀을 때
    @PostMapping("/register")
    public String registerPost(Guestbook guestbook) {
        guestbookRepository.save(guestbook);
        return "redirect:/"; // 저장 후 메인 목록으로 돌아가기
    }

    @GetMapping("/read")
    public String read(@RequestParam("gno") Long gno, Model model){
        Guestbook guestbook = guestbookRepository.findById(gno).orElseThrow();
        model.addAttribute("dto", guestbook);
        return "read";
    }

}