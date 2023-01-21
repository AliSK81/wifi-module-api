package com.example.wifimodule.controller;

import com.example.wifimodule.dto.StateDto;
import com.example.wifimodule.entity.State;
import com.example.wifimodule.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class StateController {

    private final StateService stateService;

    @PostMapping("/")
    public ResponseEntity<State> saveTime(@RequestBody StateDto dto) {
        State state = State.builder().onn(dto.getOn()).off(dto.getOff()).build();
        State savedState = stateService.saveState(state);
        return ResponseEntity.ok(savedState);
    }

    @GetMapping("/")
    public ResponseEntity<String> getTime() {
        State state = stateService.getState();
        return ResponseEntity.ok(state.toString());
    }

}
