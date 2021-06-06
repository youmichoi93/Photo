package com.austin.home.controller;


import com.austin.home.model.Board;
import com.austin.home.repository.BoardRepository;
import com.austin.home.repository.UserRepository;
import com.austin.home.service.UserService;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;


    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards",boards);
        return "board/list";
    }





    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
      if(id == null){
          model.addAttribute("board", new Board());

      }else {
          Board board = boardRepository.findById(id).orElse(null);
          model.addAttribute("board", new Board());

      }

      return "board/form";
    }


    @PostMapping("/form")
    public String postForm(@Valid Board board, BindingResult bindingResult, Authentication authentication) {
       boardRepository.save(board);
       return "redirect:/board/list";
    }


}
