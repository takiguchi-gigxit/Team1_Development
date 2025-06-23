package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.NoticeRequestDto;
import com.example.demo.dto.response.NoticeResponseDto;
import com.example.demo.entity.User;
import com.example.demo.repository.NoticeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class NoticeController {

    private final NoticeService noticeService;
    private final UserRepository userRepository;
    private final NoticeRepository noticeRepository;

    /**
     * すべての通知を取得するエンドポイント
     * 
     * @return 通知のリスト
     */
    @GetMapping
    public ResponseEntity<List<NoticeResponseDto>> getAll() {
        return ResponseEntity.ok(noticeService.getAllNotices());
    }

    /**
     * 新しい通知を作成するエンドポイント
     * 
     * @param dto 通知作成に必要なデータを持つDTO
     * @param authentication 認証情報（ログインユーザーの取得に使用）
     * @return 作成された通知のDTO
     * @throws RuntimeException ユーザーが見つからない場合
     */
    @PostMapping
    public ResponseEntity<NoticeResponseDto> create(
            @RequestBody NoticeRequestDto dto,
            Authentication authentication) {

        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("ユーザーが見つかりません"));

        return ResponseEntity.ok(noticeService.createNotice(dto, user));
    }
    
    /**
     * 指定IDの通知を削除するエンドポイント
     * 
     * @param id 削除対象の通知ID
     * @return 削除成功メッセージ
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotices(@PathVariable Long id){
        noticeRepository.deleteById(id);
        return ResponseEntity.ok("削除しました。");
    }
}
