package com.etsia.interaction.infrastructure.controller;

import com.etsia.interaction.application.service.FollowChannelUseCase;
import com.etsia.interaction.application.service.UnFollowChannelUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channelFollow")
@CrossOrigin("*")
class ChannelFollowController {
    private final FollowChannelUseCase followChannelUseCase;
    private final UnFollowChannelUseCase unFollowChannelUseCase;

    ChannelFollowController(FollowChannelUseCase followChannelUseCase, UnFollowChannelUseCase unFollowChannelUseCase) {
        this.followChannelUseCase = followChannelUseCase;
        this.unFollowChannelUseCase = unFollowChannelUseCase;
    }

    @PostMapping("/follow/{channelId}/{followerId}")
    ResponseEntity follow(@PathVariable int channelId, @PathVariable int followerId) {
        try {
            followChannelUseCase.execute(channelId, followerId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/unfollow/{channelId}/{followerId}")
    ResponseEntity unfollow(@PathVariable int channelId, @PathVariable int followerId) {
        try {
            unFollowChannelUseCase.execute(channelId, followerId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
