package com.example.wifimodule.service;

import com.example.wifimodule.entity.State;
import com.example.wifimodule.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StateService {
    private final StateRepository stateRepository;

    private final static Long DEFAULT_ON = 1000L;
    private final static Long DEFAULT_OFF = 1000L;

    public State saveState(State state) {
        state.setId(0L);
        return stateRepository.save(state);
    }

    public State getState() {
        return stateRepository.findById(0L).orElse(
                State.builder().id(0L).onn(DEFAULT_ON).off(DEFAULT_OFF).build()
        );
    }
}
