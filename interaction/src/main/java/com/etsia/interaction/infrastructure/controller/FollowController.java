package com.etsia.interaction.infrastructure.controller;

import com.etsia.interaction.application.service.FollowUseCase;
import com.etsia.interaction.application.service.UnFollowUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/follow")
@CrossOrigin("*")
class FollowController {

    private final FollowUseCase followUseCase;
    private final UnFollowUseCase unFollowUseCase;


    FollowController(FollowUseCase followUseCase, UnFollowUseCase unFollowUseCase) {
        this.followUseCase = followUseCase;
        this.unFollowUseCase = unFollowUseCase;
    }

    @PostMapping("/{followerId}/{followedId}")
    public ResponseEntity follow(@PathVariable int followerId, @PathVariable int followedId) {
        try {
            followUseCase.execute(followerId, followedId);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/unfollow/{followerId}/{followedId}")
    public ResponseEntity unfollow(@PathVariable Integer followerId, @PathVariable Integer followedId) {
        try {
            unFollowUseCase.execute(followerId, followedId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
