package com.djd.ttc.mapping;

import com.djd.ttc.model.Guest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestMapper {
    public List<Guest> findall();
}
