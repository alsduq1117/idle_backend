package com.idle.idle_backend.walk.Service;

import com.idle.idle_backend.user.domain.User;
import com.idle.idle_backend.user.domain.UserRepository;
import com.idle.idle_backend.walk.Entity.Walk;
import com.idle.idle_backend.walk.Repository.WalkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class WalkService {

    private final WalkRepository walkRepository;
    private final UserRepository userRepository;

    public Long createWalk(Long longId, String routeImage, LocalDateTime startTime, LocalDateTime finishTime, LocalDateTime energyFinishTime, Long energyFinishDistance, Float distance) {
        //user 예외처리

        Optional<User> findUser = userRepository.findById(longId);
        User user = findUser.get();

        Walk walk = Walk.builder()
                .user(user)
                .routeImage(routeImage)
                .startTime(startTime)
                .finishTime(finishTime)
                .energyFinishTime(energyFinishTime)
                .energyFinishDistance(energyFinishDistance)
                .distance(distance)
                .build();

        walkRepository.save(walk);

        return walk.getId();
    }

    public Walk getWalk(Long longId, Long walkId) {

        Optional<Walk> byId = walkRepository.findById(walkId);
        Walk walk = byId.get();


        return walk;
    }
}
