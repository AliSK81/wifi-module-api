package com.example.wifimodule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class State {
    @Id
    private Long id;
    private Long onn;
    private Long off;

    @Override
    public String toString() {
        return "ON=" + onn + "&OFF=" + off;
    }
}
